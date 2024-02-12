package com.supabaseconnector.artifact2.entity.journey;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey_ledger")
public class JourneyLedger {

    @Column(name = "journey_ledger_id")
    long journeyLedgerId;

    @Column(name = "journey_id")
    long journeyId;

    @Column(name = "luggage_income")
    long luggageIncome;

    @Column(name = "journey_passenger_row_list")
    List<JourneyPassengerRow> journeyPassengerRowList; // size is same as passengerOnboardingStops.size()

    @Column(name = "journey_passenger_combined_income")
    long journeyPassengercombinedIncome;

    @Column(name = "diesel_expense")
    long dieselExpense;

    @Column(name = "misc_expense") // miscellaneous expense
    long miscExpense;
}
