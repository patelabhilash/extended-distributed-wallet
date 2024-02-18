package com.supabaseconnector.artifact2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.NonAccidentRepairExpensePaidSeparately;

public interface NonAccidentRepairExpensePaidSeparatelyRepository
        extends JpaRepository<NonAccidentRepairExpensePaidSeparately, Long> {

    public NonAccidentRepairExpensePaidSeparately findByNarepsId(Long narepsId);

    public void deleteByNarepsId(Long id);

}