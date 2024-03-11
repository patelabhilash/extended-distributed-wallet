package com.supabaseconnector.artifact2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "device_meta_data")
public class DeviceMetaData {

    @Id
    @MapsId
    @OneToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    private Device device;

    @Column(name = "other_data")
    private String otherData;
}
