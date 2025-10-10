package com.hrps.attendanceservice.dto.request;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO used when employee submits a leave request.
 */
public class LeaveRequestRequestDTO {
    private UUID employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
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
