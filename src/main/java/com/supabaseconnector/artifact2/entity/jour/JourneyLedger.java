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
import lombok.Data;

@Data
@Entity
@Table(name = "journey_ledger")
public class JourneyLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_ledger_id")
    private long journeyLedgerId;

    @OneToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @Column(name = "luggage_income")
    private long luggageIncome;

    @OneToMany(mappedBy = "journeyLedger", orphanRemoval = true)
    private List<JourneyPassengerRow> journeyPassengerRowList; // size is same as passengerOnboardingStops.size()

    @Column(name = "journey_passenger_combined_income")
    private long journeyPassengercombinedIncome;

    @Column(name = "diesel_expense")
    private long dieselExpense;

    @Column(name = "misc_expense") // miscellaneous expense
    private long miscExpense;
}
