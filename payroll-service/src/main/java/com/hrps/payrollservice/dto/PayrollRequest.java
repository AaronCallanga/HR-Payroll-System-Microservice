package com.hrps.payrollservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PayrollRequest {
    private UUID employeeId;
    private BigDecimal baseSalary;
    private BigDecimal bonus;
    private BigDecimal deductions;
    private LocalDate payPeriodStart;
    private LocalDate payPeriodEnd;

    public PayrollRequest() {
    }

    public PayrollRequest(UUID employeeId,
                          BigDecimal baseSalary,
                          BigDecimal bonus,
                          BigDecimal deductions,
                          LocalDate payPeriodStart,
                          LocalDate payPeriodEnd) {
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
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

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
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
