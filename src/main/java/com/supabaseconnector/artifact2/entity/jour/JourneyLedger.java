package com.supabaseconnector.artifact2.entity.jour;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey_ledger")
public class JourneyLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_ledger_id")
    long journeyLedgerId;

    @OneToOne
    @JoinColumn(name = "journey_id")
    Journey journey;

    @Column(name = "luggage_income")
    long luggageIncome;

    @OneToMany(mappedBy = "journeyLedger", orphanRemoval = true)
    List<JourneyPassengerRow> journeyPassengerRowList; // size is same as passengerOnboardingStops.size()

    @Column(name = "journey_passenger_combined_income")
    long journeyPassengercombinedIncome;

    @Column(name = "diesel_expense")
    long dieselExpense;

    @Column(name = "misc_expense") // miscellaneous expense
    long miscExpense;
}
