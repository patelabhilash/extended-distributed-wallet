package com.supabaseconnector.artifact2.entity.jour;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_id")
    private long journeyId;

    @Column(name = "journey_start_date")
    private Date journeyStartDate;

    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @OneToOne
    @JoinColumn(name = "chasis_no")
    private Vehicle vehicle;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Employee> employees;

    @OneToOne(mappedBy = "journey", orphanRemoval = true)
    private JourneyLedger journeyLedgerId;

}
