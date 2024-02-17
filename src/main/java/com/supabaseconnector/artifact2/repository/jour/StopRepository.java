package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.supabaseconnector.artifact2.entity.jour.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {

    @NonNull
    List<Stop> findAll();

    Stop findByStopId(Long stopId);

    List<Stop> findByRouteRouteId(Long routeRouteId);
}