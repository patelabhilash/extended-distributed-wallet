package com.supabaseconnector.artifact2.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "non_accident_repair_paid_separately")
public class NonAccidentRepairPaidSeparately {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nareps_id")
    private Long narepsId;

    @Column(name = "vehicle_id")
    private String vehicleId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "paid_by")
    private String paidBy;

    @Column(name = "repair_shop_name")
    private String repairShopName;

    @Column(name = "parts_name")
    private String partsName;

    @Column(name = "note")
    private String note;

}
