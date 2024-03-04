package com.supabaseconnector.artifact2.entity.jour;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private long routeId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_origin_id")
    private RouteOrigin origin;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_destination_id")
    private RouteDestination destination;

    @Column(name = "distance_in_km")
    private double distanceInKm;

    @Column(name = "travel_duration_in_hour")
    private double travelDurationInHour;

    @Column(name = "is_arrival_on_same_day")
    private boolean isArrivalOnSameDay;

    @OneToMany(mappedBy = "route", orphanRemoval = true)
    private List<Stop> stops;

    public Route(String originLocation, LocalTime departureTime, String destinationLocation, LocalTime arrivalTime){
        this.origin = new RouteOrigin(departureTime , originLocation);
        this.destination = new RouteDestination(arrivalTime, destinationLocation);
    }

    

    public Route(RouteOrigin origin, RouteDestination destination){
        this.origin = origin;
        this.destination = destination;
    }

}
