package com.hrps.attendanceservice.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO used when employee submits a leave request.
 */
public class LeaveRequestRequestDTO {
    @NotNull(message = "Employee ID is required.")
    private UUID employeeId;

    @NotBlank(message = "Leave type is required.")
    @Size(max = 50, message = "Leave type must be at most 50 characters.")
    private String leaveType;

    @NotNull(message = "Start date is required.")
    @FutureOrPresent(message = "Start date cannot be in the past.")
    private LocalDate startDate;

    @NotNull(message = "End date is required.")
    @FutureOrPresent(message = "End date cannot be in the past.")
    private LocalDate endDate;

    @Size(max = 500, message = "Reason must not exceed 500 characters.")
    private String reason;

    public LeaveRequestRequestDTO() {
    }

    public LeaveRequestRequestDTO(UUID employeeId, String leaveType, LocalDate startDate, LocalDate endDate, String reason) {
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
