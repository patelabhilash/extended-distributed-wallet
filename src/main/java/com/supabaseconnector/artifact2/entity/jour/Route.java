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
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    long routeId;

    @OneToOne
    @JoinColumn(name = "location_id", insertable=false, updatable=false)
    Location origin;

    @OneToOne
    @JoinColumn(name = "location_id", insertable=false, updatable=false)
    Location destination;

    @Column(name = "distance_in_km")
    double distanceInKm;

    @Column(name = "departure_time")
    String departureTime;

    @Column(name = "arrival_time")
    String arrivalTime;

    @Column(name = "travel_duration_in_hour")
    double travelDurationInHour;

    @Column(name = "is_arrival_same_day")
    boolean isArrivalSameDay;

    @OneToMany(mappedBy = "route", orphanRemoval = true)
    List<Stop> allStops;

    @OneToMany
    @JoinColumn(name = "stop_id")
    List<Stop> passengerOnboardingStops;

    @OneToMany
    @JoinColumn(name = "stop_id")
    List<Stop> refreshmentStops;

}
