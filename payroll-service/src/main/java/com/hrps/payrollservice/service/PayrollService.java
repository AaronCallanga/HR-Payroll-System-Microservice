package com.hrps.payrollservice.service;

import com.hrps.payrollservice.dto.PayrollRequest;
import com.hrps.payrollservice.dto.PayrollResponse;
import com.hrps.payrollservice.grpc.EmployeeServiceGrpcClient;
import com.hrps.payrollservice.mapper.PayrollMapper;
import com.hrps.payrollservice.model.Payroll;
import com.hrps.payrollservice.repository.PayrollRepository;
import employee.EmployeeResponse;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;
    private final EmployeeServiceGrpcClient employeeServiceGrpcClient;

    public PayrollService(PayrollRepository payrollRepository, EmployeeServiceGrpcClient employeeServiceGrpcClient) {
        this.payrollRepository = payrollRepository;
        this.employeeServiceGrpcClient = employeeServiceGrpcClient;
    }

    /**
     * Create a new payroll entry
     */
    public PayrollResponse createPayroll(PayrollRequest request) {
        EmployeeResponse employeeResponse = employeeServiceGrpcClient.getEmployee(request.getEmployeeId());

        Payroll payroll = PayrollMapper.toEntity(request, employeeResponse);

        Payroll savedPayroll = payrollRepository.save(payroll);
        return PayrollMapper.toResponse(savedPayroll);
    }

    /**
     * Get all payroll records
     */
    public List<PayrollResponse> getAllPayrolls() {
        return payrollRepository.findAll()
                                .stream()
                                .map(PayrollMapper::toResponse)
                                .collect(Collectors.toList());
    }

    /**
     * Get payroll by ID
     */
    public PayrollResponse getPayrollById(Long id) {
        return PayrollMapper.toResponse(payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found")));
    }

    /**
     * Update status (e.g., mark as PAID)
     */
    public PayrollResponse updateStatus(Long id, String status) {

        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found"));

        payroll.setStatus(status);
        if ("PAID".equalsIgnoreCase(status)) {
            payroll.setPaymentDate(java.time.LocalDate.now());
        }

        Payroll updated = payrollRepository.save(payroll);
        return PayrollMapper.toResponse(updated);
    }

    /**
     * Delete payroll record (optional)
     */
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
