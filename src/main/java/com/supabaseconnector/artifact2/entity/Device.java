package com.supabaseconnector.artifact2.entity;

import java.time.LocalDateTime;

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
    private LocalDateTime registrationDate;

    @Column(name = "is_active")
    private boolean isActive; // manually set to active Once registered

    /*
    *so imei is the userid and the key is the password encoded with base64.
    *authentication is done is we use backend and if only supabase is used then will simply check if key equals device_access_code.
    *store a key in the app. encrypt it and store the encrypted in the db as device_access_code.
    */
    @Column(name = "device_access_code")
    private String deviceAccessCode; //

    @Column(name = "device_unlock_code")
    private String deviceUnlockCode; // manually given to user to be used in loginScreen of the app to access real features of the app.
}
