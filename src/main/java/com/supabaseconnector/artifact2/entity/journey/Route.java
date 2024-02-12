package com.supabaseconnector.artifact2.entity.journey;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    long routeId;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    Location sourceStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    Location destinationStation;

    @Column(name = "distance_in_km")
    double distanceInKm;

    @Column(name = "departure_time")
    String departureTime;

    @Column(name = "arrival_time")
    String arrivalTime;

    @Column(name = "travel_duration_in_hour")
    double travelDurationInHour;

    @OneToMany(mappedBy = "route")
    List<Stop> allStops;

    @OneToMany(mappedBy = "route")
    List<Stop> passengerOnboardingStops;

    @OneToMany(mappedBy = "route")
    List<Stop> refreshmentStops;

}
