package com.supabaseconnector.artifact2.repository.acci;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.acci.Accident;

public interface AccidentRepository extends JpaRepository<Accident, Long> {

    List<Accident> findByChasisNo(String chasisNo);

    List<Accident> findByAccidentDateBetween(Date from, Date to);

}