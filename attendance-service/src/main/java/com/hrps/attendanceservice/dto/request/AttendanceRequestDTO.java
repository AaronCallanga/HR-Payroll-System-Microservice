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
}
