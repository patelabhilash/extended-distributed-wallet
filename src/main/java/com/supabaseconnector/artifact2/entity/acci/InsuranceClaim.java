package com.supabaseconnector.artifact2.entity.acci;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance_claim")
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_claim_id")
    long insuranceClaimId;

    @Column(name = "accident_repair_expense_id")
    long accidentRepairExpenseId;

    @Column(name = "claim_received_date")
    Date claimReceivedDate;

    // paid to is to a bank_E
    // amount will be 0 as it's E to E transaction
}

