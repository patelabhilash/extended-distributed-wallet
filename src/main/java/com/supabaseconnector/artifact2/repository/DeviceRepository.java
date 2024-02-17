package com.supabaseconnector.artifact2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supabaseconnector.artifact2.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findByDeviceName(String deviceName);
    
    Device findByImei(String imei);

    @Query("SELECT d FROM Device d WHERE d.deviceName LIKE %?1%")
    List<Device> findByDeviceNameContains(String name);

}