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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RouteOrigin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_origin_id")
    private long routeOriginId;

    @OneToOne(mappedBy = "origin")
    private Route route;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @ManyToOne
    @JoinColumn(name = "location_name")
    private Location location;

    public RouteOrigin(LocalTime departureTime, String location) {
        this.departureTime = departureTime;
        this.location = new Location(location);
    }

    public RouteOrigin(LocalTime departureTime, Location location) {
        this.departureTime =departureTime;
        this.location = location;
    }
    
}
