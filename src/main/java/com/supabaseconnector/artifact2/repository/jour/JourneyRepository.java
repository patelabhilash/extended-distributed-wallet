package com.supabaseconnector.artifact2.repository.jour;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.Journey;

public interface JourneyRepository extends JpaRepository<Journey, Long> {

  List<Journey> findByJourneyStartDate(LocalDate journeyStartDate);


}