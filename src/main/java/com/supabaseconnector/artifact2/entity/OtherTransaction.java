package com.supabaseconnector.artifact2.entity;

// investor, other, bank, business transaction
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "other_transaction")
public class OtherTransaction {

    @Column(name = "o_id")
    long oId;

    // add financialTransactionClass
}
