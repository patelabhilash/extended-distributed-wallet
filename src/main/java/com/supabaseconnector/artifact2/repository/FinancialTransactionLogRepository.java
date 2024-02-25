package com.supabaseconnector.artifact2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.FinancialTransactionLog;
import com.supabaseconnector.artifact2.entity.Wallet;
import com.supabaseconnector.artifact2.util.Constraints.TransactionType;

public interface FinancialTransactionLogRepository extends JpaRepository<FinancialTransactionLog, Long> {

    List<FinancialTransactionLog> findByTransactionType(TransactionType type);
    
    List<FinancialTransactionLog> findByPaidBy(Wallet wallet);

    List<FinancialTransactionLog> findByPaidTo(Wallet wallet);
    
    List<FinancialTransactionLog> findByTransactionDateBetween(LocalDate startDate, LocalDate endDate);

}