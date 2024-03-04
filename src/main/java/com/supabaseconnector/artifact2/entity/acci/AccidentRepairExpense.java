package com.supabaseconnector.artifact2.entity.acci;

import com.supabaseconnector.artifact2.entity.FinancialTransactionLog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accident_repair_expense")
public class AccidentRepairExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_repair_expense_id")
    private long accidentRepairExpenseId;

    @ManyToOne
    @JoinColumn(name = "accident_id")
    private Accident accident;

    @OneToOne(optional = true, orphanRemoval = true)
    private InsuranceClaim insuranceClaim;

    // paid to will be fetched
    // paid by will be REPAIR_SHOP_E

    @Column(name = "repair_shop_name")
    private String repairShopName;

    @Column(name = "parts_name")
    private String partsName;
    
    // uni-directional
    @OneToOne(optional = true, orphanRemoval = true)
    @JoinColumn(name = "financial_transaction_log_id")
    private FinancialTransactionLog ftl;

}
