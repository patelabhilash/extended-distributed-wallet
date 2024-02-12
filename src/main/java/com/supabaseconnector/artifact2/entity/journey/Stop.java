package com.supabaseconnector.artifact2.entity.journey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "stop")
public class Stop {

    @Column(name = "stop_id")
    long stopId;

    @Column(name = "location_id")
    long locationId;

    @Column(name = "arrival_time")
    String arrivalTime;

    @Column(name = "departure_time")
    String departureTime;

    @Column(name = "stop_duration_in_minute")
    int stopDurationInMinute;

}
