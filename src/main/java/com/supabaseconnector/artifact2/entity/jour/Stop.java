package com.supabaseconnector.artifact2.entity.jour;

import java.time.LocalTime;

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
@Table(name = "stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    private long stopId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne(optional = true)
    @JoinColumn(name = "location_name")
    private Location location;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "stop_duration_in_minute")
    private int stopDurationInMinute;

    @Column(name = "is_passenger_fare_start_zone")
    private boolean isPassengerFareStartZone;

    @Column(name = "is_refreshment_stop")
    private  boolean isRefreshmentStop;

}
