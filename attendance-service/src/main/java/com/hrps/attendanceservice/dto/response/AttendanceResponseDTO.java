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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
