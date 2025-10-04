package com.hrps.employeeservice.dto;

import com.hrps.employeeservice.model.Department;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class EmployeeResponse {
    private UUID id;  // UUID primary key

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private String role;
    private Double salary;
    private String status = "ACTIVE";

    private DepartmentResponse department;
}
