package com.hrps.employeeservice.service;

import com.hrps.employeeservice.dto.EmployeeRequest;
import com.hrps.employeeservice.dto.EmployeeResponse;
import com.hrps.employeeservice.kafka.EmployeeEventProducer;
import com.hrps.employeeservice.mapper.EmployeeMapper;
import com.hrps.employeeservice.model.Department;
import com.hrps.employeeservice.model.Employee;
import com.hrps.employeeservice.repository.DepartmentRepository;
import com.hrps.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeEventProducer employeeEventProducer;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
                           EmployeeEventProducer employeeEventProducer) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeEventProducer = employeeEventProducer;
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {

        Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Save employee to db
        Employee employee = employeeRepository.save(EmployeeMapper.toEntity(employeeRequest, department));

        EmployeeResponse employeeResponse = EmployeeMapper.toResponse(employee);

        // Produce Kafka send event to topic "employee-created" (use proto generated class/ avro schema)
        employeeEventProducer.sendEmployeeCreatedEvent(employee);
        //  Listeners:
        //  - Payroll Service create payroll profile (OPTIONAL)
        //  - Leave Service initializes leave quota  - DONE
        //  - Performance Review Service creates evaluation record - DONE
        //  - Notifaction Service sends welcome message (even just print only or implement email) - DONE

        return employeeResponse;
    }

    public Employee updateEmployee(UUID employeeId, EmployeeRequest employeeRequest) {

        // published kafka event,

        return null;
    }

    public void deactivateEmployee() {}

    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                                 .map(EmployeeMapper::toResponse)
                                 .collect(Collectors.toList());
    }

    public EmployeeResponse getEmployeeById(UUID id) {
        return EmployeeMapper.toResponse(employeeRepository.findById(id)
                                                           .orElseThrow(() -> new RuntimeException("Employee not found")));
    }
}
