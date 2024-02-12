package com.supabaseconnector.artifact2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "device")
public class Device {

    @Column(name = "device_id")
    long deviceId;

    @Column(name = "device_name")
    String deviceName;

    @Column(name = "imei")
    String imei;

    @Column(name = "is_active")
    boolean isActive; // manually set to active Once registered

    @Column(name = "device_access_code")
    String deviceAccessCode; // manually given to user

}
