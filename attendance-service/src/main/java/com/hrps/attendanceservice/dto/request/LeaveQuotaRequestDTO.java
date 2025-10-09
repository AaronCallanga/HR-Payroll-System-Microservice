package com.hrps.attendanceservice.dto.request;

import java.util.UUID;

/**
 * DTO for creating or updating leave quota for an employee.
 */
public class LeaveQuotaRequestDTO {
    private UUID employeeId;
    private int totalLeaves;
    private int usedLeaves;

    public LeaveQuotaRequestDTO() {
    }

    public LeaveQuotaRequestDTO(UUID employeeId, int totalLeaves, int usedLeaves) {
        this.employeeId = employeeId;
        this.totalLeaves = totalLeaves;
        this.usedLeaves = usedLeaves;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public int getTotalLeaves() {
        return totalLeaves;
    }

    public void setTotalLeaves(int totalLeaves) {
        this.totalLeaves = totalLeaves;
    }

    public int getUsedLeaves() {
        return usedLeaves;
    }

    public void setUsedLeaves(int usedLeaves) {
        this.usedLeaves = usedLeaves;
    }
}
