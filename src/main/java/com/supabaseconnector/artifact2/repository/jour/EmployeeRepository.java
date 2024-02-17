package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.jour.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByShortName(String shortName);
    
    List<Employee> findByFullName(String fullName);

}