package com.supabaseconnector.artifact2.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.OtherTransaction;

public interface OtherTransactionRepository extends JpaRepository<OtherTransaction, Long> {

  List<OtherTransaction> findByAmountGreaterThan(BigDecimal amount);
  
  List<OtherTransaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

  Long countByType(String type);

}