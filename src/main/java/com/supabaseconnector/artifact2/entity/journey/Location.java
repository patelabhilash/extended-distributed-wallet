package com.supabaseconnector.artifact2.entity.journey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

    @Column(name = "location_id")
    long locationId;

    @Column(name = "location_name")
    String locationName;

}
