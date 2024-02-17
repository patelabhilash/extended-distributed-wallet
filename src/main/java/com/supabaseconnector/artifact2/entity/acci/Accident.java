package com.supabaseconnector.artifact2.entity.acci;

import java.util.Date;

import com.supabaseconnector.artifact2.util.Constraints.AccidentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_id")
    private long accidentId;

    @Column(name = "chasis_no")
    private String chasisNo;

    @Column(name = "accident_date")
    private Date accidentDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "status")
    private AccidentStatus status;

}
