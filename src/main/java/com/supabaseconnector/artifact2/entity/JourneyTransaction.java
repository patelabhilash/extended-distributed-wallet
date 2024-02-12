package com.supabaseconnector.artifact2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey_transaction")
public class JourneyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_transaction_id")
    long journeyTransactionId;

    @Column(name = "journey_id")
    long journeyId;

    /*
     * true for income
     * false for SET non-accident_repair_expense_included_in_journey
     */
    @Column(name = "is_income")
    boolean isIncome;

    // paidTo or paidBy is JOURNEY_E depending on is it income or expense.

}
