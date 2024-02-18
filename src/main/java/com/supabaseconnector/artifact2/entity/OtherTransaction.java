package com.supabaseconnector.artifact2.entity;

// investor, other, bank, business transaction
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
@Table(name = "other_transaction")
public class OtherTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private long oId;

    // uni-directional
    @OneToOne(optional = true, orphanRemoval = true)
    @JoinColumn(name = "financial_transaction_log_id")
    private FinancialTransactionLog ftl;

}
