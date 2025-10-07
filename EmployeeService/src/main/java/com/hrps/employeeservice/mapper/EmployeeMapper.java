package com.hrps.employeeservice.mapper;

import com.hrps.employeeservice.dto.DepartmentResponse;
import com.hrps.employeeservice.dto.EmployeeRequest;
import com.hrps.employeeservice.dto.EmployeeResponse;
import com.hrps.employeeservice.model.Department;
import com.hrps.employeeservice.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class EmployeeMapper {

    /**
     * Converts Employee entity to EmployeeResponse DTO
     */
    public static EmployeeResponse toResponse(Employee employee) {
        if (employee == null) {
            return null;
        }

        Department department = employee.getDepartment();
        DepartmentResponse departmentResponse = null;

        if (department != null) {
            departmentResponse = new DepartmentResponse(department.getId(), department.getName());
        }

        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getRole(),
                employee.getSalary(),
                employee.getStatus(),
                departmentResponse
        );
    }

    /**
     * Converts EmployeeRequest DTO to Employee entity
     *
     * Note: Department should be set separately by service layer
     * after fetching from DB using departmentId.
     */
    public static Employee toEntity(EmployeeRequest request, Department department) {
        if (request == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setHireDate(request.getHireDate());
        employee.setRole(request.getRole());
        employee.setSalary(request.getSalary());
        employee.setStatus(request.getStatus() != null ? request.getStatus() : "ACTIVE");
        employee.setDepartment(department);
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());

        return employee;
    }

    public static employee.EmployeeResponse toEmployeeResponse(Employee employeeEntity) {
        if (employeeEntity == null) {
            return employee.EmployeeResponse.getDefaultInstance();
        }

        // Handle department name safely
        String departmentName = (employeeEntity.getDepartment() != null)
                ? employeeEntity.getDepartment().getName()
                : "";

        // Convert to proto message
        return employee.EmployeeResponse.newBuilder()
                               .setId(employeeEntity.getId().toString())
                               .setFirstName(employeeEntity.getFirstName() != null ? employeeEntity.getFirstName() : "")
                               .setLastName(employeeEntity.getLastName() != null ? employeeEntity.getLastName() : "")
                               .setEmail(employeeEntity.getEmail() != null ? employeeEntity.getEmail() : "")
                               .setPhoneNumber(employeeEntity.getPhoneNumber() != null ? employeeEntity.getPhoneNumber() : "")
                               .setHireDate(employeeEntity.getHireDate() != null ? employeeEntity.getHireDate().toString() : "")
                               .setRole(employeeEntity.getRole() != null ? employeeEntity.getRole() : "")
                               .setSalary(employeeEntity.getSalary() != null ? employeeEntity.getSalary() : 0.0)
                               .setStatus(employeeEntity.getStatus() != null ? employeeEntity.getStatus() : "ACTIVE")
                               .setDepartment(departmentName)
                               .build();
    }
}
