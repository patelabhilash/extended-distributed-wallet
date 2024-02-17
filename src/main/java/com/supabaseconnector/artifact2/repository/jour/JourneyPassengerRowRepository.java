package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.JourneyPassengerRow;

public interface JourneyPassengerRowRepository extends JpaRepository<JourneyPassengerRow, Long> {

  List<JourneyPassengerRow> findByJourneyPassengerRowId(Long journeyPassengerRowId);

  List<JourneyPassengerRow> findByJourneyLedgerJourneyLedgerId(Long journeyLedgerJourneyLedgerId);

  Long countByJourneyPassengerRowId(Long journeyPassengerRowId);

}