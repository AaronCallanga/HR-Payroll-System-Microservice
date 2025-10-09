package com.hrps.attendanceservice.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO returned after fetching or creating leave quota record.
 */
public class LeaveQuotaResponseDTO {
    private UUID id;
    private UUID employeeId;
    private int totalLeaves;
    private int usedLeaves;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LeaveQuotaResponseDTO() {
    }

    public LeaveQuotaResponseDTO(UUID id,
                                 UUID employeeId,
                                 int totalLeaves,
                                 int usedLeaves,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.totalLeaves = totalLeaves;
        this.usedLeaves = usedLeaves;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
