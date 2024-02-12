package com.supabaseconnector.artifact2.entity.acci;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accident_repair_expense")
public class AccidentRepairExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_repair_expense_id")
    long accidentRepairExpenseId;

    @Column(name = "accident_id")
    long accidentId;

    // paid to will be fetched
    // paid by will be REPAIR_SHOP_E

}
