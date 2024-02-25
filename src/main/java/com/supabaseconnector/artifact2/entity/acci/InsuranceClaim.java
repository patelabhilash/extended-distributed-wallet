package com.supabaseconnector.artifact2.entity.acci;

import java.time.LocalDate;

import com.supabaseconnector.artifact2.entity.FinancialTransactionLog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @Column(name = "accident_repair_expense_id")
    private long accidentRepairExpenseId;

    @Column(name = "claim_received_date")
    private LocalDate claimReceivedDate;

    // paid to is to a bank_E
    // amount will be 0 as it's E to E transaction
    
    // uni-directional
    @OneToOne(optional = true, orphanRemoval = true)
    @JoinColumn(name = "financial_transaction_log_id")
    private FinancialTransactionLog ftl;
}
