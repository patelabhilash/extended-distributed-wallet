package com.supabaseconnector.artifact2.entity.jour;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "chasis_no")
    private String chasisNo;

    @Column(name = "vehicleNumber")
    private String vehicleNumber;

    @Column(name = "registrationDate")
    private LocalDate registrationDate;

    @Column(name = "isFirstHand")
    private boolean isFirstHand;

    @Column(name = "seatCount")
    private int seatCount;

    @Column(name = "lastFitnessDate")
    private LocalDate lastFitnessDate;

    @Column(name = "isRetired")
    private boolean isRetired; // default false

}
