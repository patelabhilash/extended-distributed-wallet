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
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private long routeId;

    @OneToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location origin;

    @OneToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location destination;

    @Column(name = "distance_in_km")
    private double distanceInKm;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "travel_duration_in_hour")
    private double travelDurationInHour;

    @Column(name = "is_arrival_same_day")
    private boolean isArrivalSameDay;

    @OneToMany(mappedBy = "route", orphanRemoval = true)
    private List<Stop> allStops;

    @OneToMany
    @JoinColumn(name = "stop_id")
    private List<Stop> passengerOnboardingStops;

    @OneToMany
    @JoinColumn(name = "stop_id")
    private List<Stop> refreshmentStops;

}
