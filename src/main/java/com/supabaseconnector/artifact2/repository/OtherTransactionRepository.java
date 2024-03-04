package com.supabaseconnector.artifact2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.OtherTransaction;

public interface OtherTransactionRepository extends JpaRepository<OtherTransaction, Long> {

  OtherTransaction findByFtlFinancialTransactionLogId(Long ftlId);

  //may need to move to FTL
  // List<OtherTransaction> findByAmountGreaterThan(BigDecimal amount);
  
  //may need to move to FTL
  // List<OtherTransaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
  
  //may need to move to FTL
  // Long countByType(String type);

}