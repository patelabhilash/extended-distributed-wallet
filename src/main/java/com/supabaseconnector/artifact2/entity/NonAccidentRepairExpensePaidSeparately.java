package com.supabaseconnector.artifact2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "non_accident_repair_paid_separately")
public class NonAccidentRepairExpensePaidSeparately {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nareps_id")
    private Long narepsId;

    @Column(name = "vehicle_id")
    private String vehicleId;

    @Column(name = "repair_shop_name")
    private String repairShopName;

    @Column(name = "parts_name")
    private String partsName;

    // uni-directional
    @OneToOne(optional = true, orphanRemoval = true)
    @JoinColumn(name = "financial_transaction_log_id")
    private FinancialTransactionLog ftl;

}
