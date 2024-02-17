package com.supabaseconnector.artifact2.entity.jour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey_passenger_row")
public class JourneyPassengerRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_passenger_row_id")
    long journeyPassengerRowId;

    @ManyToOne
    @JoinColumn(name = "journey_ledger_id")
    JourneyLedger journeyLedger;

    @Column(name = "passenger_count")
    long passengerCount;

    @Column(name = "price_per_head")
    long pricePerHead;

}
