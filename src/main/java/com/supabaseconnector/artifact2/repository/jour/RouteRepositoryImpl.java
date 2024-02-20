package com.supabaseconnector.artifact2.repository.jour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supabaseconnector.artifact2.entity.jour.Location;
import com.supabaseconnector.artifact2.entity.jour.Route;
import com.supabaseconnector.artifact2.entity.jour.RouteDestination;
import com.supabaseconnector.artifact2.entity.jour.RouteOrigin;

@Service
public class RouteRepositoryImpl {

    @Autowired
    LocationRepository locationRepository;

    public Route saveRoute(String originLocation, String departureTime, String destinationLocation){
        if(originLocation == null || departureTime == null || destinationLocation == null) {
            return null;
        }

        RouteOrigin r = new RouteOrigin(departureTime, locationRepository.findById(originLocation).orElse( new Location(originLocation)));
        RouteDestination d =  new RouteDestination(null,locationRepository.findById(destinationLocation).orElse(new Location(destinationLocation)));
        return new Route(r, d);
    }
}
