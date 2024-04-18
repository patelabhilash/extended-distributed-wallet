package com.supabaseconnector.artifact2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.FinancialTransactionLog;
import com.supabaseconnector.artifact2.util.Constraints.TransactionType;


public interface FinancialTransactionLogRepository extends JpaRepository<FinancialTransactionLog, Long> {

    List<FinancialTransactionLog> findByTransactionType(TransactionType type);
    
    List<FinancialTransactionLog> findByPaidBy(String paidBy);

    List<FinancialTransactionLog> findByPaidTo(String paidTo);
    
    List<FinancialTransactionLog> findByTransactionDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<FinancialTransactionLog> findByTransactionTypeAndTransactionDateBetween( TransactionType transactionType, LocalDateTime startDate, LocalDateTime endDate);

    List<FinancialTransactionLog> findByTransactionDate(LocalDateTime transactionDate);

}