package com.hrps.attendanceservice.service;

import com.hrps.attendanceservice.dto.request.AttendanceRequestDTO;
import com.hrps.attendanceservice.dto.response.AttendanceResponseDTO;
import com.hrps.attendanceservice.entity.AttendanceRecord;
import com.hrps.attendanceservice.mapper.AttendanceMapper;
import com.hrps.attendanceservice.repository.AttendanceRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttendanceService {

    private final AttendanceRecordRepository attendanceRecordRepository;

    public AttendanceService(AttendanceRecordRepository attendanceRecordRepository) {
        this.attendanceRecordRepository = attendanceRecordRepository;
    }

    /**
     * Marks or updates attendance manually or via API.
     */
    public AttendanceResponseDTO markAttendance(AttendanceRequestDTO request) {
        AttendanceRecord entity = AttendanceMapper.toEntity(request);
        AttendanceRecord saved = attendanceRecordRepository.save(entity);
        return AttendanceMapper.toResponseDTO(saved);
    }

    /**
     * Gets all attendance records for an employee.
     */
    public List<AttendanceResponseDTO> getByEmployee(UUID employeeId) {
        return AttendanceMapper.toResponseDTOList(attendanceRecordRepository.findByEmployeeId(employeeId));
    }

    /**
     * Gets all attendance records (for admin reports).
     */
    public List<AttendanceResponseDTO> getAll() {
        return AttendanceMapper.toResponseDTOList(attendanceRecordRepository.findAll());
    }
}

