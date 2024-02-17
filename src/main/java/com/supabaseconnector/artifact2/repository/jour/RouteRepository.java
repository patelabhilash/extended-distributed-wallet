package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

  // List<Route> findByOriginAndDestination(String originLocationName, String destinationLocationName);
  
  List<Route> findByDistanceInKmLessThan(double distanceInKm);

  List<Route> findByTravelDurationInHourGreaterThan(double travelDurationInHour);

}