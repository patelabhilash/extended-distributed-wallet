package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supabaseconnector.artifact2.entity.jour.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByLocationId(Long locationId);

    List<Location> findByLocationName(String locationName);
}