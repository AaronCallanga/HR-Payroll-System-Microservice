package com.hrps.attendanceservice.dto.response;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO used for listing multiple leave requests. (maybe for admin)
 */
public class LeaveRequestListResponseDTO {
    private UUID id;
    private UUID employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // PENDING, APPROVED, REJECTED
}
