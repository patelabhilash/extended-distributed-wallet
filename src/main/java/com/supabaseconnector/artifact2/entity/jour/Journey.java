package com.supabaseconnector.artifact2.entity.jour;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_id")
    long journeyId;

    @Column(name = "journey_end_date")
    Date journeyEndDate;

    @Column(name = "route")
    Route route;

    @Column(name = "vehicle")
    Vehicle vehicle;

    @Column(name = "employees")
    List<Employee> employees;

    @Column(name = "journey_ledger_id")
    long journeyLedgerId;

}
