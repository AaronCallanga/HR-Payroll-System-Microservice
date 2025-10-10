package com.hrps.attendanceservice.controller;

import com.hrps.attendanceservice.dto.response.LeaveHistoryResponseDTO;
import com.hrps.attendanceservice.service.LeaveHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Displays leave history for reporting and employee tracking.
 */
@RestController
@RequestMapping("/api/leave-history")
public class LeaveHistoryController {

    private final LeaveHistoryService leaveHistoryService;

    public LeaveHistoryController(LeaveHistoryService leaveHistoryService) {
        this.leaveHistoryService = leaveHistoryService;
    }

    /**
     * Get all leave history records.
     */
    @GetMapping
    public ResponseEntity<List<LeaveHistoryResponseDTO>> getAll() {
        return ResponseEntity.ok(leaveHistoryService.getAll());
    }

    /**
     * Get leave history for a specific employee.
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveHistoryResponseDTO>> getByEmployee(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(leaveHistoryService.getByEmployee(employeeId));
    }
}