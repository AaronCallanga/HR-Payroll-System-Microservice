package com.hrps.payrollservice.controller;

import com.hrps.payrollservice.dto.PayrollRequest;
import com.hrps.payrollservice.dto.PayrollResponse;
import com.hrps.payrollservice.service.PayrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    /**
     * Create payroll
     */
    @PostMapping
    public ResponseEntity<PayrollResponse> createPayroll(@RequestBody PayrollRequest request) {
        PayrollResponse response = payrollService.createPayroll(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get all payrolls
     */
    @GetMapping
    public ResponseEntity<List<PayrollResponse>> getAllPayrolls() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }

    /**
     * Get payroll by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PayrollResponse> getPayrollById(@PathVariable Long id) {
        return ResponseEntity.ok(payrollService.getPayrollById(id));
    }

    /**
     * Update payroll status (e.g., mark as PAID)
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<PayrollResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(payrollService.updateStatus(id, status));
    }

    /**
     * Delete payroll (optional)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}
