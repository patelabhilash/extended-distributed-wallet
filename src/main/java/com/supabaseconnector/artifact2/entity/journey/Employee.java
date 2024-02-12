package com.supabaseconnector.artifact2.entity.journey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    long employeeId;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "short_name")
    String shortName;

    @Column(name = "role")
    String role; // driver,conductor, helper, manager etc.

    @Column(name = "aadhar_no")
    String aadharNo;

    @Column(name = "is_document_complete")
    boolean isDocumentComplete;
}
