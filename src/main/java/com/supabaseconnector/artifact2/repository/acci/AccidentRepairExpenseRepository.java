package com.supabaseconnector.artifact2.repository.acci;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.supabaseconnector.artifact2.entity.acci.AccidentRepairExpense;

@Repository
public interface AccidentRepairExpenseRepository extends JpaRepository<AccidentRepairExpense, Long> {

  List<AccidentRepairExpense> findByAccidentAccidentId(long accidentId);

  List<AccidentRepairExpense> getByAccidentAccidentId( long accidentId);

  /* //disabled as currently not in use
   
  @Modifying
  @Query("UPDATE AccidentRepairExpense a SET a.accidentId = :accidentId WHERE a.accidentRepairExpenseId = :id")
  void updateAccidentId(@Param("id") long id, @Param("accidentId") long accidentId);
  */
  
}