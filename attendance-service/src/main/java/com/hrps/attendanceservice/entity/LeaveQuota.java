package com.hrps.attendanceservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "leave_quota")
public class LeaveQuota {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "employee_id", nullable = false)
    private UUID employeeId; // Reference to Employee Service

    @Column(name = "total_leaves", nullable = false)
    private int totalLeaves = 15;

    @Column(name = "used_leaves", nullable = false)
    private int usedLeaves = 0;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    public LeaveQuota() {
    }

    public LeaveQuota(UUID id,
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
