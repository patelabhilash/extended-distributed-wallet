package com.supabaseconnector.artifact2.entity.acci;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "insurance_claim")
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_claim_id")
    private long insuranceClaimId;

    @OneToOne(mappedBy = "insuranceClaim")
    private AccidentRepairExpense accidentRepairExpense;

    @Column(name = "claim_received_date")
    private LocalDate claimReceivedDate;

    @Column(name = "amount_claimed")
    private double amountClaimed;

    @Column(name = "bank_name")
    private String bankName; //to be populated from wallet subcategory the bank_E

    //no transaction log for this as E to E transacation
    // claimed amount and vehicle id can be track from this table
}
