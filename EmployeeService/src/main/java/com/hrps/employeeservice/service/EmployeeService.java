package com.hrps.employeeservice.service;

import com.hrps.employeeservice.dto.EmployeeRequest;
import com.hrps.employeeservice.dto.EmployeeResponse;
import com.hrps.employeeservice.mapper.EmployeeMapper;
import com.hrps.employeeservice.model.Department;
import com.hrps.employeeservice.model.Employee;
import com.hrps.employeeservice.repository.DepartmentRepository;
import com.hrps.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {

        Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Save employee to db
        Employee employee = employeeRepository.save(EmployeeMapper.toEntity(employeeRequest, department));

        EmployeeResponse employeeResponse = EmployeeMapper.toResponse(employee);
        // Produce Kafka send event to topic "employee-created" (use proto generated class)
        //  Listeners:
        //  - Payroll Service create payroll profile
        //  - Leave Service initializes leave quota
        //  - Performance Review Service creates evaluation record
        //  - Notifaction Service sends welcome message (even just print only or implement email)

        return employeeResponse;
    }
}
