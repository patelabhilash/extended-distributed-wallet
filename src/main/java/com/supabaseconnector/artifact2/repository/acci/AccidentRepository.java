package com.supabaseconnector.artifact2.repository.acci;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.acci.Accident;

public interface AccidentRepository extends JpaRepository<Accident, Long> {

    List<Accident> findByVehicleChasisNo(String chasisNo);

    // List<Accident> findByAccidentBetween(LocalDate from, LocalDate to);

}
