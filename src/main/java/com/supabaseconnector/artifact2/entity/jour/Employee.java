package com.supabaseconnector.artifact2.entity.jour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "role")
    private String role; // driver,conductor, helper, manager etc.

    @Column(name = "aadhar_no")
    private String aadharNo;

    @Column(name = "is_document_complete")
    private boolean isDocumentComplete;
}
