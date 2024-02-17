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
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private long deviceId;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "imei")
    private String imei;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "is_active")
    private boolean isActive; // manually set to active Once registered

    @Column(name = "device_access_code")
    private String deviceAccessCode; // manually given to user

}
