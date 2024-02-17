package com.supabaseconnector.artifact2.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.OtherTransaction;

public interface OtherTransactionRepository extends JpaRepository<OtherTransaction, Long> {

  //may need to move to FTL
  // List<OtherTransaction> findByAmountGreaterThan(BigDecimal amount);
  
  //may need to move to FTL
  // List<OtherTransaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
  
  //may need to move to FTL
  // Long countByType(String type);

}