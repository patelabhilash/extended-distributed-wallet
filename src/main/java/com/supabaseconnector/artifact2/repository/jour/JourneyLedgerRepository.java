package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.JourneyLedger;

public interface JourneyLedgerRepository extends JpaRepository<JourneyLedger, Long> {

  List<JourneyLedger> findByOriginAndDestination(String origin, String destination);
  
  JourneyLedger findFirstByOrderByIdDesc();

}