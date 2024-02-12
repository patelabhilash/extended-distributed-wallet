package com.supabaseconnector.artifact2.entity;

import java.util.Date;

import com.supabaseconnector.artifact2.entity.Constraints.AccidentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "accident")
public class Accident {

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
