package com.supabaseconnector.artifact2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.JourneyTransaction;

public interface JourneyTransactionRepository extends JpaRepository<JourneyTransaction, Long> {

    List<JourneyTransaction> findByJourneyTransactionId(Long journeyTransactionId);
    
    JourneyTransaction findFirstByOrderByJourneyTransactionIdDesc();
    
    Long countByJourneyTransactionId(Long journeyTransactionId);

}