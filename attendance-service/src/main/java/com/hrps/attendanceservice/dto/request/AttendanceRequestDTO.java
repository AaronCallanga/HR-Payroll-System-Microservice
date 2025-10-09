package com.hrps.attendanceservice.dto.request;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for submitting attendance update or creation.
 */
public class AttendanceRequestDTO {
    private UUID employeeId;
    private LocalDate attendanceDate;
    private String status; // PRESENT, ABSENT, PENDING

    public AttendanceRequestDTO() {
    }

    public AttendanceRequestDTO(UUID employeeId, LocalDate attendanceDate, String status) {
        this.employeeId = employeeId;
        this.attendanceDate = attendanceDate;
        this.status = status;
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
