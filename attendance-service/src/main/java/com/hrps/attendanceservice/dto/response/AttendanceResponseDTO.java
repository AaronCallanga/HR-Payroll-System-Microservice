package com.hrps.attendanceservice.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO returned after fetching attendance records.
 */
public class AttendanceResponseDTO {
    private UUID id;
    private UUID employeeId;
    private LocalDate attendanceDate;
    private String status;

    public AttendanceResponseDTO() {
    }

    public AttendanceResponseDTO(UUID id, UUID employeeId, LocalDate attendanceDate, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.attendanceDate = attendanceDate;
        this.status = status;
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

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
