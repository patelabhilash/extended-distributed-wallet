package com.supabaseconnector.artifact2.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.supabaseconnector.artifact2.entity.Wallet;
import com.supabaseconnector.artifact2.entity.jour.Employee;
import com.supabaseconnector.artifact2.entity.jour.Route;
import com.supabaseconnector.artifact2.entity.jour.Vehicle;
import com.supabaseconnector.artifact2.repository.WalletRepository;
import com.supabaseconnector.artifact2.util.Constraints.DefaultWalletName;
import com.supabaseconnector.artifact2.util.Constraints.WalletCategory;
import com.supabaseconnector.artifact2.util.Constraints.WalletType;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // this is where you can insert data into the database

        // TODO convert enums to new tables

        if (shouldInitializeDatabase()) {
            initializeData();
            log.info("Data initialized successfully.");
        } else {
            log.info("Database already contains data. Skipping initialization.");
        }

    }

    private void initializeData() {

        Route r1 = new Route();
        addRoute(r1);
        Vehicle v1 = new Vehicle();
        addVehicle(v1);
        Employee e1 = new Employee();
        addEmployee(e1);

        // example of inserting data into the database
        List<Wallet> wallets = Arrays.asList(
                new Wallet(0, WalletType.EXTERNAL, WalletCategory.Hidden_E, "first",
                        "code-source-destination-departuretime", 0),
                new Wallet(0, WalletType.EXTERNAL, WalletCategory.Hidden_E, "second",
                        "code-source-destination-departuretime", 0));
        walletRepository.saveAll(wallets);

        Arrays.stream(DefaultWalletName.values())
                .map(walletName -> new Wallet(0,
                        walletName.name().endsWith("_I") ? WalletType.INTERNAL : WalletType.EXTERNAL,
                        WalletCategory.miscellaneous_E,
                        walletName.name(), "some starts with code", 0))
                .forEach(walletRepository::save);
    }

    private void addEmployee(Employee e1) {
        System.out.println("add employee");
        System.out.println("add corresponding wallet");
        System.out.println("save data to db");
    }
    
    private void addVehicle(Vehicle v1) {
        System.out.println("add vehicle");
        System.out.println("add corresponding wallet");
        System.out.println("save data to db");
    }
    
    private void addRoute(Route r1) {
        System.out.println("add route");
        System.out.println("add corresponding wallet");
        System.out.println("save data to db");

    }

    private boolean shouldInitializeDatabase() {
        // Check if any entities exist in the database
        return walletRepository.findAll().isEmpty(); // Or your preferred check
    }
}