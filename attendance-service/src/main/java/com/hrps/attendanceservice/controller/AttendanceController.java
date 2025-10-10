package com.hrps.attendanceservice.controller;

import com.hrps.attendanceservice.dto.request.AttendanceRequestDTO;
import com.hrps.attendanceservice.dto.response.AttendanceResponseDTO;
import com.hrps.attendanceservice.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Manages attendance tracking for employees.
 */
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    /**
     * Get all attendance records.
     */
    @GetMapping
    public ResponseEntity<List<AttendanceResponseDTO>> getAll() {
        return ResponseEntity.ok(attendanceService.getAll());
    }

    /**
     * Get attendance records by employee.
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<List<AttendanceResponseDTO>> getByEmployee(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(attendanceService.getByEmployee(employeeId));
    }

    /**
     * Mark or update an attendance record.
     */
    @PostMapping
    public ResponseEntity<AttendanceResponseDTO> markAttendance(@RequestBody AttendanceRequestDTO request) {
        return ResponseEntity.ok(attendanceService.markAttendance(request));
    }
}
