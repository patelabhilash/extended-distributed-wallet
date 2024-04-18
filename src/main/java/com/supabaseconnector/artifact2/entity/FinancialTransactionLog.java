package com.supabaseconnector.artifact2.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.supabaseconnector.artifact2.util.Constraints.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "financial_transaction_log")
public class FinancialTransactionLog {

    // ALLOWED VALUES: J , N , O :: RE, I
    // I is from

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financial_transaction_log_id")
    private long financialTransactionLogId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "transaction_id")
    private long transactionId;

    @Column(name = "note")
    private String note;

    @Column(name = "additional_desc")
    private String additionalDesc;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @UpdateTimestamp
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "last_updated_device_id")
    private String lastUpdatedDeviceId;

    //wallet name of paid by
    @Column(name = "paid_by_id")
    private String paidBy;

    //wallet name of paid to
    @Column(name = "paid_to_id")
    private String paidTo;

    @Column(name = "amount")
    private long amount;

}
