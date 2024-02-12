package com.supabaseconnector.artifact2.entity.journey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey_passenger_row")
public class JourneyPassengerRow {

    @Column(name = "journey_passenger_row_id")
    long journeyPassengerRowId;

    @Column(name = "journey_ledger_id")
    long journeyLedgerId;

}
