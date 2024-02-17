package com.supabaseconnector.artifact2.entity.jour;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    long stopId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    Route route;

    @OneToOne
    @JoinColumn(name = "location_id")
    Location location;

    @Column(name = "arrival_time")
    LocalTime arrivalTime;

    @Column(name = "departure_time")
    LocalTime departureTime;

    @Column(name = "stop_duration_in_minute")
    int stopDurationInMinute;

}
