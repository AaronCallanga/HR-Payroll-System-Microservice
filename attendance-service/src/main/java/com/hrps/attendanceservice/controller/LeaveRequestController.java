package com.hrps.attendanceservice.controller;

import com.hrps.attendanceservice.dto.request.LeaveRequestRequestDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestListResponseDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestResponseDTO;
import com.hrps.attendanceservice.service.LeaveRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Handles employee leave request submissions and approvals.
 */
@RestController
@RequestMapping("/attendance/leave-requests")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    /**
     * Submit a new leave request.
     */
    @PostMapping
    public ResponseEntity<LeaveRequestResponseDTO> submitLeave(@RequestBody LeaveRequestRequestDTO dto) {
        return ResponseEntity.ok(leaveRequestService.submitRequest(dto));
    }

    /**
     * Approve or reject a leave request.
     * Can separate the approve, reject, update to different endpoint so you just need to send the leave request id
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<LeaveRequestResponseDTO> updateStatus(
            @PathVariable UUID id,
            @RequestParam String status,
            @RequestParam String approver
                                                            ) {
        return ResponseEntity.ok(leaveRequestService.updateStatus(id, status, approver));
    }

    /**
     * Get all leave requests (for admin/HR view).
     */
    @GetMapping
    public ResponseEntity<List<LeaveRequestListResponseDTO>> getAll() {
        return ResponseEntity.ok(leaveRequestService.getAll());
    }

    /**
     * Get all leave requests by employee ID.
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveRequestListResponseDTO>> getByEmployee(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(leaveRequestService.getByEmployee(employeeId));
    }
}
