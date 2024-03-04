package com.supabaseconnector.artifact2.repository.jour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.supabaseconnector.artifact2.entity.jour.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByShortName(String shortName);

    List<Employee> findByFullName(String fullName);

    Employee findByEmployeeId(long employeeId);

    List<Employee> findByAadharNo(String aadharNo);

    List<Employee> findByMobileNo(String mobileNo);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employee SET " +
            "fullName = COALESCE(:fullName, fullName), " +
            "shortName = COALESCE(:shortName, shortName), " +
            "role = COALESCE(:role, role), " +
            "aadharNo = COALESCE(:aadharNo, aadharNo), " +
            "mobileNo = COALESCE(:mobileNo, mobileNo), " +
            "isDocumentComplete = COALESCE(:isDocumentComplete, isDocumentComplete), " +
            "isActive = COALESCE(:isActive, isActive), " +
            "WHERE employeeId = :employeeId", nativeQuery = true)
    void updateEmployee(@Param("employeeId") Long employeeId, @Param("fullName") String fullName,
            @Param("shortName") String shortName, @Param("role") String role, @Param("aadharNo") String aadharNo,
            @Param("mobileNo") String mobileNo, @Param("isDocumentComplete") Boolean isDocumentComplete,
            @Param("isActive") Boolean isActive);

}