package com.supabaseconnector.artifact2.entity.jour;

import jakarta.persistence.CascadeType;
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
public class RouteDestination {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_destination_id")
    private long routeDestinationId;

    @OneToOne(mappedBy = "destination")
    private Route route;
    
    @Column(name = "arrival_time")
    private String arrivalTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_name")
    private Location location;

    public RouteDestination(String arrivalTime, String location) {
        this.arrivalTime = arrivalTime;
        this.location = new Location(location);
    }

    public RouteDestination(String arrivalTime, Location location) {
        this.arrivalTime = arrivalTime;
        this.location = location;
    }
    
}
