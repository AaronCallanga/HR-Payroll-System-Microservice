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
}
