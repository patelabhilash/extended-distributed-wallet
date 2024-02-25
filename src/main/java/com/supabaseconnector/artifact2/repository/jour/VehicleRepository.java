package com.supabaseconnector.artifact2.repository.jour;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

  List<Vehicle> findByChasisNo(String chasisNo);
  
  List<Vehicle> findByVehicleNumber(String vehicleNumber);

  List<Vehicle> findBylastFitnessDateLessThan(LocalDate todayOrFutureDate);

}