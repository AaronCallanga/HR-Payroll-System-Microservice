package com.hrps.employeeservice.service;

import com.hrps.employeeservice.dto.EmployeeRequest;
import com.hrps.employeeservice.dto.EmployeeResponse;
import com.hrps.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {

    }
}
