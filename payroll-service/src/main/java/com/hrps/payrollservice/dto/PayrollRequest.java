package com.hrps.payrollservice.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PayrollRequest {
    @NotNull(message = "Employee ID is required")
    private UUID employeeId;

    // Get through gRPC communication
//    @NotNull(message = "Base salary is required")
//    @DecimalMin(value = "0.00", inclusive = false, message = "Base salary must be greater than 0")
//    private BigDecimal baseSalary;

    @DecimalMin(value = "0.00", inclusive = true, message = "Bonus cannot be negative")
    private BigDecimal bonus = BigDecimal.ZERO;

    @DecimalMin(value = "0.00", inclusive = true, message = "Deductions cannot be negative")
    private BigDecimal deductions = BigDecimal.ZERO;

    @NotNull(message = "Pay period start date is required")
    private LocalDate payPeriodStart;

    @NotNull(message = "Pay period end date is required")
    @FutureOrPresent(message = "Pay period end date cannot be in the past")
    private LocalDate payPeriodEnd;

    public PayrollRequest() {
    }

    public PayrollRequest(UUID employeeId,
                          BigDecimal bonus,
                          BigDecimal deductions,
                          LocalDate payPeriodStart,
                          LocalDate payPeriodEnd) {
        this.employeeId = employeeId;
        this.bonus = bonus;
        this.deductions = deductions;
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public LocalDate getPayPeriodStart() {
        return payPeriodStart;
    }

    public void setPayPeriodStart(LocalDate payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public LocalDate getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public void setPayPeriodEnd(LocalDate payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }
}
