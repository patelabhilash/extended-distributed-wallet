package com.supabaseconnector.artifact2.model;

import java.util.List;

import com.supabaseconnector.artifact2.entity.jour.Location;
import com.supabaseconnector.artifact2.entity.jour.Stop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RouteModel {

    private long routeId;

    private Location origin; 


    private Location destination;


    private double distanceInKm;


    private String departureTime;


    private String arrivalTime;


    private double travelDurationInHour;

    private boolean isArrivalOnSameDay;

    private List<Stop> allStops; // get all stop

    private List<Stop> passengerOnboardingStops; //get stops where isPassengerFareStartZone = true

    private List<Stop> refreshmentStops;  //get stops where isRefreshmentStop = true

}
