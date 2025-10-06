package com.hrps.payrollservice.mapper;

import com.hrps.payrollservice.dto.PayrollRequest;
import com.hrps.payrollservice.dto.PayrollResponse;
import com.hrps.payrollservice.model.Payroll;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PayrollMapper {
    /**
     * Converts a PayrollRequest DTO into a Payroll entity.
     * Calculates the netPay = baseSalary + bonus - deductions.
     */
    public static Payroll toEntity(PayrollRequest request) {
        if (request == null) {
            return null;
        }

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(request.getEmployeeId());
        payroll.setBaseSalary(request.getBaseSalary());
        payroll.setBonus(request.getBonus() != null ? request.getBonus() : BigDecimal.ZERO);
        payroll.setDeductions(request.getDeductions() != null ? request.getDeductions() : BigDecimal.ZERO);

        // Calculate net pay
        BigDecimal netPay = request.getBaseSalary()
                                   .add(payroll.getBonus())
                                   .subtract(payroll.getDeductions());
        payroll.setNetPay(netPay);

        payroll.setPayPeriodStart(request.getPayPeriodStart());
        payroll.setPayPeriodEnd(request.getPayPeriodEnd());
        payroll.setPaymentDate(null); // initially null until processed
        payroll.setStatus("PENDING");
        payroll.setCreatedAt(LocalDateTime.now());

        return payroll;
    }

    /**
     * Converts a Payroll entity into a PayrollResponse DTO.
     */
    public static PayrollResponse toResponse(Payroll payroll) {
        if (payroll == null) {
            return null;
        }

        PayrollResponse response = new PayrollResponse();
        response.setId(payroll.getId());
        response.setEmployeeId(payroll.getEmployeeId());
        response.setBaseSalary(payroll.getBaseSalary());
        response.setBonus(payroll.getBonus());
        response.setDeductions(payroll.getDeductions());
        response.setNetPay(payroll.getNetPay());
        response.setPayPeriodStart(payroll.getPayPeriodStart());
        response.setPayPeriodEnd(payroll.getPayPeriodEnd());
        response.setPaymentDate(payroll.getPaymentDate());
        response.setStatus(payroll.getStatus());
        response.setCreatedAt(payroll.getCreatedAt());

        return response;
    }

    /**
     * Updates an existing Payroll entity with new data from PayrollRequest.
     * Useful for PUT/PATCH operations.
     */
    public static void updateEntity(Payroll payroll, PayrollRequest request) {
        if (payroll == null || request == null) {
            return;
        }

        payroll.setBaseSalary(request.getBaseSalary());
        payroll.setBonus(request.getBonus() != null ? request.getBonus() : BigDecimal.ZERO);
        payroll.setDeductions(request.getDeductions() != null ? request.getDeductions() : BigDecimal.ZERO);
        payroll.setPayPeriodStart(request.getPayPeriodStart());
        payroll.setPayPeriodEnd(request.getPayPeriodEnd());

        // Recalculate net pay
        BigDecimal netPay = request.getBaseSalary()
                                   .add(payroll.getBonus())
                                   .subtract(payroll.getDeductions());
        payroll.setNetPay(netPay);
    }
}
