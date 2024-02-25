package com.supabaseconnector.artifact2.util;

import java.io.InputStream;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supabaseconnector.artifact2.entity.Wallet;
import com.supabaseconnector.artifact2.entity.jour.Employee;
import com.supabaseconnector.artifact2.entity.jour.Location;
import com.supabaseconnector.artifact2.entity.jour.Route;
import com.supabaseconnector.artifact2.entity.jour.RouteDestination;
import com.supabaseconnector.artifact2.entity.jour.RouteOrigin;
import com.supabaseconnector.artifact2.entity.jour.Vehicle;
import com.supabaseconnector.artifact2.model.ERVHolder;
import com.supabaseconnector.artifact2.model.InitHolder;
import com.supabaseconnector.artifact2.repository.WalletRepository;
import com.supabaseconnector.artifact2.repository.jour.EmployeeRepository;
import com.supabaseconnector.artifact2.repository.jour.LocationRepository;
import com.supabaseconnector.artifact2.repository.jour.RouteRepository;
import com.supabaseconnector.artifact2.repository.jour.VehicleRepository;
import com.supabaseconnector.artifact2.util.Constraints.WalletCategory;
import com.supabaseconnector.artifact2.util.Constraints.WalletType;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private static final String TOURIST_SPOT = "TOURIST_SPOT";

    private static final Location TOURIST_SPOT_LOCATION = new Location(TOURIST_SPOT);

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private LocationRepository locationRepository; 

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private ERVHolder ervHolder;

    private InitHolder initHolder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("Initializing data...");
        log.info("Initializing data from file: init-data.json" );
        InputStream initHolderStream = new ClassPathResource("static/init-data.json").getInputStream();
        InputStream ervHolderStream = new ClassPathResource("static/erv-data.json").getInputStream();
        initHolder = objectMapper.readValue(initHolderStream, InitHolder.class);
        log.info("data from file: init-data.json initialized successfully.");
        log.info("Initializing data from file: init-data.json");
        ervHolder = objectMapper.readValue(ervHolderStream, ERVHolder.class);
        log.info("data from file: erv-data.json initialized successfully.");

        // TODO convert enums to new tables

        initializeConstantRoutes();
        initializeConstantWallets();
        initializeWalletsFromInitData();
        initializeWalletsFromERVHolder();
        log.info("Data initialized successfully.");

    }

    private void initializeConstantRoutes() {
        initializeRoute(TOURIST_SPOT, LocalTime.MIDNIGHT,TOURIST_SPOT); // sameday arrival logic
        initializeRoute(TOURIST_SPOT, LocalTime.NOON,TOURIST_SPOT);     //nextday arrival logic
    }

    private void initializeRoute(String originLocationName, LocalTime originDepartureTime, String destinationLocationName){
        if(originLocationName == null || originDepartureTime == null || destinationLocationName == null) {
            return;
        }
        Route r = routeRepository.findByOriginLocationLocationNameAndOriginDepartureTimeAndDestinationLocationLocationName(originLocationName, originDepartureTime, destinationLocationName);
        if(r == null) {
            r = getRoute(originLocationName, originDepartureTime, destinationLocationName);
            routeRepository.save(r);
        }
    }


    private Route getRoute(String originLocation, LocalTime departureTime, String destinationLocation) {
        if(originLocation == null || departureTime == null || destinationLocation == null) {
            return null;
        }
        // Check if the locations exist in the database, and save them if they don't
        Location origin = locationRepository.findById(originLocation).orElseGet(() -> locationRepository.save(new Location(originLocation)));
        Location destination = locationRepository.findById(destinationLocation).orElseGet(() -> locationRepository.save(new Location(destinationLocation)));
    
        // Create and return the Route object
        if (origin != null && destination != null) {
            RouteOrigin routeOrigin = new RouteOrigin(departureTime, origin);
            RouteDestination routeDestination = new RouteDestination(null, destination);
            return new Route(routeOrigin, routeDestination);
        } else {
            return null;
        }
    }
    

    private void initializeConstantWallets() {
        List<Wallet> wallets = List.of(
                new Wallet("business_maintenance_and_expansion", "", WalletType.EXTERNAL,
                        WalletCategory.miscellaneous_E, 0),
                new Wallet("miscellaneous", "", WalletType.EXTERNAL, WalletCategory.miscellaneous_E, 0),
                new Wallet("Adjustment_E", "", WalletType.EXTERNAL, WalletCategory.Adjustment_E, 0),

                new Wallet("Route_Tourist_sameDayArrival", "on tourist permit", WalletType.EXTERNAL,
                        WalletCategory.Hidden_E, 0),
                new Wallet("Route_Tourist_nextDayArrival", "on tourist permit", WalletType.EXTERNAL,
                        WalletCategory.Hidden_E, 0));

        wallets.stream().filter(w -> !doesWalletExist(w.getWalletName())).forEach(walletRepository::save);

    }

    private void initializeWalletsFromERVHolder() {

        List<Employee> employees = ervHolder.getEmployees();
        List<Route> routes = ervHolder.getRoutes();
        List<Vehicle> vehicles = ervHolder.getVehicles();

        if (employees != null) {
            for (Employee employee : employees) {
                initializeEmployeeAndItsWallets(employee);
            }
        }

        if (routes != null) {
            for (Route route : routes) {
                initializeRouteAndItsWallet(route);
            }
        }

        if (vehicles != null) {
            for (Vehicle vehicle : vehicles) {
                initializeVehicleAndItsWallet(vehicle);
            }
        }

    }

    private void initializeWalletsFromInitData() {
        List<String> owners = initHolder.getOwners();
        List<String> lockers = initHolder.getLockers();
        List<String> banks = initHolder.getBanks();
        List<String> importants = initHolder.getImportants();
        List<Wallet> wallets = initHolder.getWallets();
        if (owners != null) {
            for (String owner : owners) {
                if (!doesWalletExist("Owner_" + owner + "_I")) {
                    walletRepository.save(new Wallet("Owner_" + owner + "_I", "internal owner wallet",
                            WalletType.INTERNAL, WalletCategory.Owner, 0.0));
                }
                if (!doesWalletExist("Owner_" + owner + "_E")) {
                    walletRepository.save(new Wallet("Owner_" + owner + "_E", "external owner wallet",
                            WalletType.EXTERNAL, WalletCategory.Owner, 0.0));
                }
            }
        }
        if (lockers != null) {
            for (String locker : lockers) {
                if (!doesWalletExist("Locker_" + locker + "_I")) {
                    walletRepository.save(new Wallet("Locker_" + locker + "_I", "internal locker wallet",
                            WalletType.INTERNAL, WalletCategory.Locker, 0.0));
                }
            }
        }
        if (banks != null) {
            for (String bank : banks) {
                if (!doesWalletExist(bank + "_Bank_E")) {
                    walletRepository.save(new Wallet(bank + "_Bank_E", "external bank wallet", WalletType.EXTERNAL,
                            WalletCategory.Bank_E, 0.0));
                }
            }
        }
        if (importants != null) {
            for (String important : importants) {
                if (!doesWalletExist("VIP_" + important + "_E")) {
                    walletRepository.save(new Wallet("VIP_" + important + "_E", "tracking as important person",
                            WalletType.EXTERNAL, WalletCategory.ImportantPerson_E, 0.0));
                }
            }
        }
        if (wallets != null) {
            for (Wallet wallet : wallets) {
                if (!doesWalletExist(wallet.getWalletName())) {
                    walletRepository.save(wallet);
                }
            }
        }
    }

    private void initializeEmployeeAndItsWallets(Employee employee) {
        if (employee == null || employee.getShortName() == null) {
            log.info("Database already contains data. Skipping initialization.");
            log.error("employee is null");
            return;
        }
        String walletNameE = "EMP_" + employee.getShortName() + "_E";
        String walletNameI = "EMP_" + employee.getShortName() + "_I";

        if (employeeRepository.findByShortName(employee.getShortName()).isEmpty()
                && !doesWalletExist(walletNameE) && !doesWalletExist(walletNameI)) {
            employeeRepository.save(employee);
            walletRepository.save(new Wallet(walletNameE, "emp - " + employee.getShortName() + " - external wallet",
                    WalletType.EXTERNAL, WalletCategory.Employee, 0.0));
            walletRepository.save(new Wallet(walletNameI, "emp - " + employee.getShortName() + " - internal wallet",
                    WalletType.INTERNAL, WalletCategory.Employee, 0.0));
        } else {
            log.info("Database already contains data. Skipping initialization.");
            log.error(walletNameE + " OR " + walletNameI + " OR " + "employee : " + employee.getShortName()
                    + " already exists");
        }
    }

    private void initializeVehicleAndItsWallet(Vehicle vehicle) {
        if (vehicle == null || vehicle.getChasisNo() == null) {
            log.info("Database already contains data. Skipping initialization.");
            log.error("vehicle is null");
            return;
        }
        String walletName = "VehicleRepair_" + vehicle.getChasisNo();
        if (vehicleRepository.findByChasisNo(vehicle.getChasisNo()).isEmpty() && !doesWalletExist(walletName)) {
            vehicleRepository.save(vehicle);
            walletRepository.save(
                    new Wallet(walletName, "vehicle repair - " + vehicle.getVehicleNumber() + " - external wallet",
                            WalletType.EXTERNAL, WalletCategory.Hidden_E, 0.0));
        } else {
            log.info("Database already contains data. Skipping initialization.");
            log.error(walletName + " OR " + "vehicle : " + vehicle.getChasisNo() + " already exists");
        }
    }

    private void initializeRouteAndItsWallet(Route route) {
        // NO LONGER initializing routes from init data. ONLY WALLET
        if (route == null || route.getOrigin() == null || route.getDestination() == null
                || route.getOrigin().getDepartureTime() == null
                || route.getOrigin().getLocation().getLocationName() == null 
                || route.getDestination().getLocation().getLocationName() == null) {
            log.info("Database already contains data. Skipping initialization.");
            log.error("route is null");
            return;
        }
        String walletName = "Route_" + route.getOrigin().getLocation().getLocationName() + "_"
                + route.getDestination().getLocation().getLocationName() + "_" + route.getOrigin().getDepartureTime();
        if (routeRepository.findByOriginLocationLocationNameAndOriginDepartureTimeAndDestinationLocationLocationName(route.getOrigin().getLocation().getLocationName(), route.getOrigin().getDepartureTime(),route.getDestination().getLocation().getLocationName()) == null && !doesWalletExist(walletName)) {
            
            walletRepository.save(
                    new Wallet(walletName,
                            "route - " + route.getOrigin().getLocation().getLocationName() + " - "
                                    + route.getDestination().getLocation().getLocationName() + " - " + route.getOrigin().getDepartureTime()
                                    + " - external wallet",
                            WalletType.EXTERNAL, WalletCategory.Hidden_E, 0.0));
        } else {
            log.info("Database already contains data. Skipping initialization.");
            log.error(walletName + " already exists");
        }

    }

    private boolean doesWalletExist(String name) {
        return walletRepository.findByWalletName(name) != null;
    }
}
