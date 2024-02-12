package com.supabaseconnector.artifact2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.NonAccidentRepairPaidSeparately;

public interface NonAccidentRepairPaidSeparatelyRepository
        extends JpaRepository<NonAccidentRepairPaidSeparately, Long> {

    public NonAccidentRepairPaidSeparately findByNarepsId(Long narepsId);

    public void deleteByNarepsId(Long id);

}