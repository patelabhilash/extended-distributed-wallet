package com.supabaseconnector.artifact2.entity;


import java.util.Date;

import com.supabaseconnector.artifact2.entity.Constraints.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "financial_transaction_log")
public class FinancialTransactionLog {

    @Column(name = "financial_transaction_log_id")
    private long financialTransactionLogId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "transaction_id")
    private long transactionId;

    @Column(name = "note")
    private String note;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    @Column(name = "last_updated_device_id")
    private String lastUpdatedDeviceId;

    @Column(name = "paid_by")
    private Wallet paidBy;

    @Column(name = "paid_to")
    private Wallet paidTo;

    @Column(name = "amount")
    private long amount;

}
