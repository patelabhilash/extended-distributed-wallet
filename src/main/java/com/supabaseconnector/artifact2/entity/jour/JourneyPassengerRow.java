package com.supabaseconnector.artifact2.entity.jour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "journey_passenger_row")
public class JourneyPassengerRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_passenger_row_id")
    private long journeyPassengerRowId;

    @ManyToOne
    @JoinColumn(name = "journey_ledger_id")
    private JourneyLedger journeyLedger;

    @Column(name = "passenger_count")
    private long passengerCount;

    @Column(name = "fare_per_head")
    private long farePerHead;

}
