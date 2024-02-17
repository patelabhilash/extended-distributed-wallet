package com.supabaseconnector.artifact2.repository.acci;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.acci.InsuranceClaim;

public interface InsuranceClaimRepository extends JpaRepository<InsuranceClaim, Long> {

  InsuranceClaim findByAccidentRepairExpenseId(long accidentRepairExpenseId);
  
  void deleteByAccidentRepairExpenseId(long accidentRepairExpenseId);


}