package com.hrps.attendanceservice.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO representing a completed leave record.
 */
public class LeaveHistoryResponseDTO {
    private UUID id;
    private UUID employeeId;
    private String leaveType; // e.g., Vacation, Sick
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalDays;
    private String reason;
    private String status; // APPROVED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
