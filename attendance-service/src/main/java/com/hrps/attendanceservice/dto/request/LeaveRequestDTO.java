package com.hrps.attendanceservice.dto.request;

import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO used when employee submits a leave request.
 */
public class LeaveRequestDTO {
    private UUID employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
}
