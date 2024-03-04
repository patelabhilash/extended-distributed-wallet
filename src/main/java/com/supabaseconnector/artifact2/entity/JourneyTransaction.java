package com.supabaseconnector.artifact2.entity;

import com.supabaseconnector.artifact2.entity.jour.Journey;

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
@Table(name = "journey_transaction")
public class JourneyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_transaction_id")
    private long journeyTransactionId;

    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    /*
     * true for income
     * false for SET non-accident_repair_expense_included_in_journey
     */
    @Column(name = "is_income")
    private boolean isIncome;

    // paidTo or paidBy is JOURNEY_E depending on is it income or expense.

    // uni-directional
    @OneToOne(optional = true, orphanRemoval = true)
    @JoinColumn(name = "financial_transaction_log_id")
    private FinancialTransactionLog ftl;

}
