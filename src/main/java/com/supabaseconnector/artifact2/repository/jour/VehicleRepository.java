package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

  List<Vehicle> findByModel(String model);
  
  List<Vehicle> findByMake(String make);

  Long countByModel(String model);

}