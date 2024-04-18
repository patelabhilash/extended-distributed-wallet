package com.supabaseconnector.artifact2.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supabaseconnector.artifact2.entity.Device;
import com.supabaseconnector.artifact2.entity.FinancialTransactionLog;
import com.supabaseconnector.artifact2.entity.NonAccidentRepairExpensePaidSeparately;
import com.supabaseconnector.artifact2.entity.OtherTransaction;
import com.supabaseconnector.artifact2.entity.Wallet;
import com.supabaseconnector.artifact2.entity.acci.Accident;
import com.supabaseconnector.artifact2.entity.acci.AccidentRepairExpense;
import com.supabaseconnector.artifact2.entity.acci.InsuranceClaim;
import com.supabaseconnector.artifact2.entity.jour.Employee;
import com.supabaseconnector.artifact2.entity.jour.Journey;
import com.supabaseconnector.artifact2.entity.jour.JourneyLedger;
import com.supabaseconnector.artifact2.entity.jour.Route;
import com.supabaseconnector.artifact2.entity.jour.Vehicle;
import com.supabaseconnector.artifact2.model.TransactionList;
import com.supabaseconnector.artifact2.repository.DeviceRepository;
import com.supabaseconnector.artifact2.repository.FinancialTransactionLogRepository;
import com.supabaseconnector.artifact2.repository.JourneyTransactionRepository;
import com.supabaseconnector.artifact2.repository.NonAccidentRepairExpensePaidSeparatelyRepository;
import com.supabaseconnector.artifact2.repository.OtherTransactionRepository;
import com.supabaseconnector.artifact2.repository.WalletRepository;
import com.supabaseconnector.artifact2.repository.jour.EmployeeRepository;
import com.supabaseconnector.artifact2.repository.jour.JourneyRepository;
import com.supabaseconnector.artifact2.repository.jour.RouteRepository;
import com.supabaseconnector.artifact2.repository.jour.VehicleRepository;
import com.supabaseconnector.artifact2.util.Constraints.TransactionType;

@Service
public class CommonApiService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    FinancialTransactionLogRepository financialTransactionLogRepository;

    @Autowired
    NonAccidentRepairExpensePaidSeparatelyRepository narepsRepository;

    @Autowired
    OtherTransactionRepository otherTransactionRepository;

    @Autowired
    JourneyTransactionRepository journeyTransactionRepository;

    @Autowired
    JourneyRepository journeyRepository;

    private ResponseEntity<String> successResponseEntity = new ResponseEntity<>("success", HttpStatus.OK);
    private final int maxAccidentPerMonth = 10;
    private final int moreDays = 1;
    private final String SUCCESS = "success";

    public ResponseEntity<String> registerDevice(Device device) {
        if (device == null || device.getImei() == null || device.getImei().isEmpty()) {
            return new ResponseEntity<String>("Invalid device", HttpStatus.BAD_REQUEST);
        }
        deviceRepository.save(device);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
    }

    public ResponseEntity<TransactionList> getPoolManagementList(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPoolManagementList'");
    }

    public ResponseEntity<List<Wallet>> getWalletList() {
        List<Wallet> allWallets = walletRepository.findAll();
        return new ResponseEntity<List<Wallet>>(allWallets, HttpStatus.OK);
    }

    public ResponseEntity<String> createWallet(Wallet wallet) {
        if (wallet == null || wallet.getWalletName() == null || wallet.getWalletName().isEmpty()
                || wallet.getWalletType() == null || wallet.getWalletCategory() == null) {
            return new ResponseEntity<String>("Invalid wallet", HttpStatus.BAD_REQUEST);
        }
        if (walletRepository.findByWalletName(wallet.getWalletName()) != null) {
            return new ResponseEntity<String>("Wallet already exists", HttpStatus.BAD_REQUEST);
        }

        walletRepository.save(wallet);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Employee>> getEmployeeList() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
    }

    public ResponseEntity<String> createEmployee(Employee employee) {
        if (employee == null || employee.getAadharNo() == null || employee.getShortName() == null) {
            return new ResponseEntity<String>("Invalid employee", HttpStatus.BAD_REQUEST);
        }
        if (employeeRepository.findByEmployeeId(employee.getEmployeeId()) != null) {
            return new ResponseEntity<String>("Employee already exists", HttpStatus.BAD_REQUEST);
        }
        if (employeeRepository.findByShortName(employee.getShortName()) != null) {
            return new ResponseEntity<String>("Employee short name already exists", HttpStatus.BAD_REQUEST);
        }
        if (employeeRepository.findByAadharNo(employee.getAadharNo()) != null) {
            return new ResponseEntity<String>("Employee aadhar no already exists", HttpStatus.BAD_REQUEST);
        }
        if (employeeRepository.findByMobileNo(employee.getMobileNo()) != null) {
            return new ResponseEntity<String>("Employee mobile no already exists", HttpStatus.BAD_REQUEST);
        }
        employeeRepository.save(employee);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateEmployee(Employee employee) {
        if (employee == null) {
            return new ResponseEntity<String>("Invalid employee", HttpStatus.BAD_REQUEST);
        }
        employeeRepository.updateEmployee(employee.getEmployeeId(), employee.getFullName(), employee.getShortName(),
                employee.getRole(), employee.getAadharNo(), employee.getMobileNo(), employee.isDocumentComplete(),
                employee.isActive());
        return new ResponseEntity<String>(SUCCESS, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Vehicle>> getVehicleList() {
        List<Vehicle> allVehicles = vehicleRepository.findAll();
        return new ResponseEntity<List<Vehicle>>(allVehicles, HttpStatus.OK);
    }

    public ResponseEntity<List<Route>> getRouteList() {
        List<Route> allRoutes = routeRepository.findAll();
        return new ResponseEntity<List<Route>>(allRoutes, HttpStatus.OK);
    }

    public TransactionList getTransactionList(LocalDate date) {
        List<Journey> journeyList = new ArrayList<>();
        Set<Long> journeyIds = new HashSet<>();
        List<NonAccidentRepairExpensePaidSeparately> narepsList = new ArrayList<>();
        List<OtherTransaction> otherTransactionList = new ArrayList<>();
        List<FinancialTransactionLog> ftls = financialTransactionLogRepository.findByTransactionDateBetween(date.atStartOfDay(),
                date.plusDays(moreDays).atStartOfDay());
        for (FinancialTransactionLog ftl : ftls) {
            if (ftl.getTransactionType().equals(TransactionType.J)) {
                journeyTransactionRepository.findByFtlFinancialTransactionLogId(ftl.getFinancialTransactionLogId())
                        .stream().map(e -> e.getJourneyTransactionId()).forEach(journeyIds::add);
            }
            if (ftl.getTransactionType().equals(TransactionType.N)) {
                narepsList.add(narepsRepository.findByFtlFinancialTransactionLogId(ftl.getFinancialTransactionLogId()));
            }
            if (ftl.getTransactionType().equals(TransactionType.BO)) {
                otherTransactionList.add(
                        otherTransactionRepository.findByFtlFinancialTransactionLogId(ftl.getFinancialTransactionLogId()));
            }

        }
        journeyList = journeyIds.stream().map(e -> journeyRepository.getReferenceById(e)).collect(Collectors.toList());

        TransactionList transactionList = new TransactionList();
        transactionList.setJourneyList(journeyList);
        transactionList.setNonAccidentRepairPaidSeparatelyList(narepsList);
        transactionList.setOtherTransactionList(otherTransactionList);
        return transactionList;
    }

    public ResponseEntity<Journey> viewJourney(long journeyId) {
        if (journeyId < 0) {
            return new ResponseEntity<Journey>(HttpStatus.BAD_REQUEST);
        }
        Journey journey = journeyRepository.getReferenceById(journeyId);
        return new ResponseEntity<Journey>(journey, HttpStatus.OK);
    }

    public ResponseEntity<String> createJourney(Journey journey) {
        //create journey without ledger and journey transaction
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createJourney'");
    }

    public ResponseEntity<String> updateJourney(Journey journey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateJourney'");
    }

    public ResponseEntity<String> createJourneyLedger(JourneyLedger journeyLedger) {
        // create journey ledger and journey transaction and create financial transaction log
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createJourneyLedger'");
    }

    public ResponseEntity<String> updateJourneyLedger(JourneyLedger journeyLedger) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateJourneyLedger'");
    }

    public ResponseEntity<JourneyLedger> viewJourneyLedger(long journeyLedgerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewJourneyLedger'");
    }

    public ResponseEntity<NonAccidentRepairExpensePaidSeparately> viewNarepsTransaction(long narepsId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewNarepsTransaction'");
    }

    public ResponseEntity<String> createNarepsTransaction(NonAccidentRepairExpensePaidSeparately nareps) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNarepsTransaction'");
    }

    public ResponseEntity<String> updateNarepsTransaction(NonAccidentRepairExpensePaidSeparately nareps) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateNarepsTransaction'");
    }

    public ResponseEntity<OtherTransaction> viewOtherTransaction(long oId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewOtherTransaction'");
    }

    public ResponseEntity<String> createOtherTransaction(OtherTransaction otherTransaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOtherTransaction'");
    }

    public ResponseEntity<String> updateOtherTransaction(OtherTransaction otherTransaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOtherTransaction'");
    }

    // -- 10 past accidents and search will start from the date mentioned till 10
    // counts regardless of 10th accident date.
    // maxAccidentPerMonth
    public ResponseEntity<List<Accident>> getAccidentReportList(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccidentReportList'");
    }

    public ResponseEntity<String> createAccident(Accident accident) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccident'");
    }

    public ResponseEntity<Accident> viewAccident(long accidentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewAccident'");
    }

    public ResponseEntity<AccidentRepairExpense> viewRepairExpense(long accidentRepairExpenseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewRepairExpense'");
    }

    public ResponseEntity<String> createRepairExpense(AccidentRepairExpense accidentRepairExpense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRepairExpense'");
    }

    public ResponseEntity<String> updateRepairExpense(AccidentRepairExpense accidentRepairExpense) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRepairExpense'");
    }

    public ResponseEntity<InsuranceClaim> viewInsuranceClaim(long insuranceClaimId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewInsuranceClaim'");
    }

    public ResponseEntity<String> createInsuranceClaim(InsuranceClaim insuranceClaim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createInsuranceClaim'");
    }

    public ResponseEntity<String> updateInsuranceClaim(InsuranceClaim insuranceClaim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInsuranceClaim'");
    }

    // maxDays
    public ResponseEntity<FinancialTransactionLog> getFinancialTransactionLog(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFinancialTransactionLog'");
    }

}
