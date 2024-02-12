package com.supabaseconnector.artifact2.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "non_accident_repair_paid_separately")
public class NonAccidentRepairPaidSeparately {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nareps_id")
    Long narepsId;

    @Column(name = "vehicle_id")
    String vehicleId;

    @Column(name = "transaction_date")
    Date transactionDate;

    @Column(name = "paid_by")
    String paidBy;

    @Column(name = "repair_shop_name")
    String repairShopName;

    @Column(name = "parts_name")
    String partsName;

    @Column(name = "note")
    String note;

}
