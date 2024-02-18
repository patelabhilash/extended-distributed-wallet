package com.supabaseconnector.artifact2.service;

import java.util.Date;
import java.util.List;

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

@Service
public class CommonApiService {

    private ResponseEntity<String> successResponseEntity = new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    private final int maxAccidentPerMonth = 10;
    private final int maxDays = 2;

    public ResponseEntity<String> registerDevice(Device device) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerDevice'");
    }

    public ResponseEntity<TransactionList> getPoolManagementList(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPoolManagementList'");
    }

    public ResponseEntity<List<Wallet>> getWalletList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWalletList'");
    }

    public ResponseEntity<String> createWallet(Wallet wallet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWallet'");
    }

    public ResponseEntity<List<Employee>> getEmployeeList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeList'");
    }

    public ResponseEntity<String> createEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEmployee'");
    }

    public ResponseEntity<String> updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    public ResponseEntity<Vehicle> getVehicleList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVehicleList'");
    }

    public ResponseEntity<Route> getRouteList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRouteList'");
    }

    public TransactionList getTransactionList(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactionList'");
    }

    public ResponseEntity<Journey> viewJourney(long journeyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewJourney'");
    }

    public ResponseEntity<String> createJourney(Journey journey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createJourney'");
    }

    public ResponseEntity<String> updateJourney(Journey journey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateJourney'");
    }

    public ResponseEntity<String> createJourneyLedger(JourneyLedger journeyLedger) {
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
    //maxAccidentPerMonth
    public ResponseEntity<List<Accident>> getAccidentReportList(Date date) {
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


    //maxDays 
    public ResponseEntity<FinancialTransactionLog> getFinancialTransactionLog(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFinancialTransactionLog'");
    }

}
