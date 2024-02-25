package com.supabaseconnector.artifact2.repository.jour;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.Route;
import com.supabaseconnector.artifact2.entity.jour.RouteDestination;
import com.supabaseconnector.artifact2.entity.jour.RouteOrigin;

public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findByOriginAndDestination(RouteOrigin origin, RouteDestination destination);

    List<Route> findByOriginLocationLocationNameAndDestinationLocationLocationName(
            String originLocationLocationName, String destinationLocationLocationName);

    Route findByOriginLocationLocationNameAndOriginDepartureTimeAndDestinationLocationLocationName(
            String originLocationLocationName, LocalTime originDepartureTime, String destinationLocationLocationName);

    List<Route> findByDistanceInKmLessThan(double distanceInKm);

    List<Route> findByTravelDurationInHourGreaterThan(double travelDurationInHour);

}