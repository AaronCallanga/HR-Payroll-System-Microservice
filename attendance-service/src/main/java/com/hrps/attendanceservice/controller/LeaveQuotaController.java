package com.hrps.attendanceservice.controller;

import com.hrps.attendanceservice.dto.response.LeaveQuotaResponseDTO;
import com.hrps.attendanceservice.service.LeaveQuotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Handles all operations related to employee leave quotas.
 */
@RestController
@RequestMapping("/leave-quotas")
public class LeaveQuotaController {

    private final LeaveQuotaService leaveQuotaService;

    public LeaveQuotaController(LeaveQuotaService leaveQuotaService) {
        this.leaveQuotaService = leaveQuotaService;
    }

    /**
     * Get all leave quotas (for admin).
     */
    @GetMapping
    public ResponseEntity<List<LeaveQuotaResponseDTO>> getAll() {
        return ResponseEntity.ok(leaveQuotaService.getAll());
    }

    /**
     * Get leave quota for a specific employee.
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<LeaveQuotaResponseDTO> getByEmployeeId(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(leaveQuotaService.getByEmployeeId(employeeId));
    }

    /**
     * Initialize leave quota (typically triggered internally by Kafka when employee is created).
     */
    @PostMapping("/init/{employeeId}")
    public ResponseEntity<LeaveQuotaResponseDTO> initializeLeaveQuota(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(leaveQuotaService.initializeLeaveQuota(employeeId));
    }
}
