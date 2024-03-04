package com.supabaseconnector.artifact2.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.supabaseconnector.artifact2.service.CommonApiService;

@RestController(value = "/v1")
public class ArtifactController {

    @Autowired
    CommonApiService commonApiService;

    @GetMapping("/version")
    public String getVersion(@RequestParam String param) {
        return new String(param + "\n version: 1.0");
    }

    /* register device API */
    @PostMapping("/register")
    public ResponseEntity<String> registerDevice(@RequestBody Device device) {
        return commonApiService.registerDevice(device);
    }

    /* pool management API start */
    @GetMapping("/p/l")
    public ResponseEntity<TransactionList> getPoolManagementList(@RequestParam LocalDate date) { // pool management list
        return commonApiService.getPoolManagementList(date);
    }

    @GetMapping("/p/wl")
    public ResponseEntity<List<Wallet>> getWalletList() { // UD in direct db
        return commonApiService.getWalletList();
    }

    @PostMapping("/p/wc")
    public ResponseEntity<String> createWallet(@RequestBody Wallet wallet) {
        return commonApiService.createWallet(wallet);
    }

    @GetMapping("/p/el")
    public ResponseEntity<List<Employee>> getEmployeeList() { // D in direct db
        return commonApiService.getEmployeeList();
    }

    @PostMapping("/p/ec")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        return commonApiService.createEmployee(employee);
    }

    @PutMapping("/p/eu")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        return commonApiService.updateEmployee(employee);
    }

    @GetMapping("/p/vl")
    public ResponseEntity<List<Vehicle>> getVehicleList() { // CUD in direct db
        return commonApiService.getVehicleList();
    }

    @GetMapping("/p/rl")
    public ResponseEntity<List<Route>> getRouteList() { // CUD in direct db
        return commonApiService.getRouteList();
    }

    /* pool management API end */
    /* Transaction API start -- events - complete all CRUD */

    @PostMapping("/t/l")
    public TransactionList getTransactionList(@RequestBody LocalDate date) { // Event list -- J, N , O
        return commonApiService.getTransactionList(date);
    }

    @GetMapping("/t/jv") // -- API may not be needed as we would already have journey data from
                         // transactionList
    public ResponseEntity<Journey> viewJourney(@RequestParam long journeyId) { // D in direct db
        return commonApiService.viewJourney(journeyId);
    }

    @PostMapping("/t/jc")
    public ResponseEntity<String> createJourney(@RequestBody Journey journey) {
        return commonApiService.createJourney(journey);
    }

    @PutMapping("/t/ju")
    public ResponseEntity<String> updateJourney(@RequestBody Journey journey) {
        return commonApiService.updateJourney(journey);
    }

    @GetMapping("/t/jlv") // journey ledger
    public ResponseEntity<JourneyLedger> viewJourneyLedger(@RequestParam long journeyLedgerId) { // D in direct db
        return commonApiService.viewJourneyLedger(journeyLedgerId);
    }

    @PostMapping("/t/jlc")
    public ResponseEntity<String> createJourneyLedger(@RequestBody JourneyLedger journeyLedger) {
        return commonApiService.createJourneyLedger(journeyLedger);
    }

    @PutMapping("/t/jlu")
    public ResponseEntity<String> updateJourneyLedger(@RequestBody JourneyLedger journeyLedger) {
        return commonApiService.updateJourneyLedger(journeyLedger);
    }

    @GetMapping("/t/nv")
    public ResponseEntity<NonAccidentRepairExpensePaidSeparately> viewNarepsTransaction(@RequestParam long narepsId) { // D in
                                                                                                                // direct
                                                                                                                // db
        return commonApiService.viewNarepsTransaction(narepsId);
    }

    @PostMapping("/t/nc")
    public ResponseEntity<String> createNarepsTransaction(@RequestBody NonAccidentRepairExpensePaidSeparately nareps) {
        return commonApiService.createNarepsTransaction(nareps);
    }

    @PutMapping("/t/nu")
    public ResponseEntity<String> updateNarepsTransaction(@RequestBody NonAccidentRepairExpensePaidSeparately nareps) {
        return commonApiService.updateNarepsTransaction(nareps);
    }

    @GetMapping("/t/ov")
    public ResponseEntity<OtherTransaction> viewOtherTransaction(@RequestParam long oId) { // D in direct db
        return commonApiService.viewOtherTransaction(oId);
    }

    @PostMapping("/t/oc")
    public ResponseEntity<String> createOtherTransaction(@RequestBody OtherTransaction otherTransaction) {
        return commonApiService.createOtherTransaction(otherTransaction);
    }

    @PutMapping("/t/ou")
    public ResponseEntity<String> updateOtherTransaction(@RequestBody OtherTransaction otherTransaction) {
        return commonApiService.updateOtherTransaction(otherTransaction);
    }

    /* Transaction API end */
    /* AccidentReport API start -- events - complete all CRUD */

    @GetMapping("/a/l")
    public ResponseEntity<List<Accident>> getAccidentReportList(@RequestBody LocalDate date) {// will show accident list not arl 
        //-- 10 past accidents and search will start from the date mentioned till 10 counts regardless of 10th accident date.
        return commonApiService.getAccidentReportList(date);
    }

    @PostMapping("/a/c")
    public ResponseEntity<String> createAccident(@RequestBody Accident accident) {// create single accident
        return commonApiService.createAccident(accident);
    }

    @GetMapping("/a/v")
    public ResponseEntity<Accident> viewAccident(@RequestParam long accidentId) {// view single accident
        return commonApiService.viewAccident(accidentId);
    }

    @GetMapping("/a/rev")
    public ResponseEntity<AccidentRepairExpense> viewRepairExpense(@RequestParam long accidentRepairExpenseId) {// view repair expense
        return commonApiService.viewRepairExpense(accidentRepairExpenseId);
    }

    @GetMapping("/a/rec")
    public ResponseEntity<String> createRepairExpense(@RequestBody AccidentRepairExpense accidentRepairExpense) {// create repair expense
        return commonApiService.createRepairExpense(accidentRepairExpense);
    }

    @GetMapping("/a/reu")
    public ResponseEntity<String> updateRepairExpense(@RequestBody AccidentRepairExpense accidentRepairExpense) {// update repair expense
        return commonApiService.updateRepairExpense(accidentRepairExpense);
    }

    @GetMapping("/a/icv")
    public ResponseEntity<InsuranceClaim> viewInsuranceClaim(@RequestParam long insuranceClaimId) {// view insurance claim
        return commonApiService.viewInsuranceClaim(insuranceClaimId);
    }

    @PostMapping("/a/icc")
    public ResponseEntity<String> createInsuranceClaim(@RequestBody InsuranceClaim insuranceClaim) {// create insurance claim
        return commonApiService.createInsuranceClaim(insuranceClaim);
    }

    @PutMapping("/a/icu")
    public ResponseEntity<String> updateInsuranceClaim(InsuranceClaim insuranceClaim) {// update insurance claim
        return commonApiService.updateInsuranceClaim(insuranceClaim);
    }

    /* AccidentReport API end */
    /* DashBoard API start -- events - complete all CRUD */

    @GetMapping("/dash")
    public String getDashBoardList(@RequestParam String param) {
        return new String();
    }

    /* DashBoard API end */
    /* Financial Transaction Log API start -- events - part of dashboard */
    @GetMapping("/ftl/l")
    public ResponseEntity<FinancialTransactionLog> getFinancialTransactionLog(@RequestBody LocalDate date) {
        // all transactionLog of the same day and 1 day past i.e. 2 days
        return commonApiService.getFinancialTransactionLog(date);
    }

}
