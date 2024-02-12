package com.supabaseconnector.artifact2.entity.journey;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Column(name = "chasisNo")
    String chasisNo; // id

    @Column(name = "vehicleNumber")
    String vehicleNumber;

    @Column(name = "registrationDate")
    Date registrationDate;

    @Column(name = "isFirstHand")
    boolean isFirstHand;

    @Column(name = "seatCount")
    int seatCount;

    @Column(name = "lastFitnessDate")
    Date lastFitnessDate;

    @Column(name = "isRetired")
    boolean isRetired; // default false

}
