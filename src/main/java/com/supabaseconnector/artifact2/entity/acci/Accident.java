package com.supabaseconnector.artifact2.entity.acci;

import java.util.Date;

import com.supabaseconnector.artifact2.util.Constraints.AccidentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_id")
    long accidentId;

    @Column(name = "chasis_no")
    String chasisNo;

    @Column(name = "accident_date")
    Date accidentDate;

    @Column(name = "updated_date")
    Date updatedDate;

    @Column(name = "status")
    AccidentStatus status;

}
