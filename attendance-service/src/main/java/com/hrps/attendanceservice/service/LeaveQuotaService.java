package com.hrps.attendanceservice.service;

import com.hrps.attendanceservice.dto.response.LeaveQuotaResponseDTO;
import com.hrps.attendanceservice.entity.LeaveQuota;
import com.hrps.attendanceservice.mapper.LeaveQuotaMapper;
import com.hrps.attendanceservice.repository.LeaveQuotaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeaveQuotaService {

    private final LeaveQuotaRepository leaveQuotaRepository;

    public LeaveQuotaService(LeaveQuotaRepository leaveQuotaRepository) {
        this.leaveQuotaRepository = leaveQuotaRepository;
    }

    /**
     * Initializes leave quota for a newly created employee (used by Kafka consumer).
     */
    // Should be kafka consumer
    public LeaveQuotaResponseDTO initializeLeaveQuota(UUID employeeId) {
        LeaveQuota quota = new LeaveQuota();
        quota.setEmployeeId(employeeId);
        quota.setTotalLeaves(15); // default value
        quota.setUsedLeaves(0);

        LeaveQuota saved = leaveQuotaRepository.save(quota);
        return LeaveQuotaMapper.toResponseDTO(saved);
    }

    /**
     * Fetch a leave quota for a specific employee.
     */
    public LeaveQuotaResponseDTO getByEmployeeId(UUID employeeId) {
        LeaveQuota quota = leaveQuotaRepository.findByEmployeeId(employeeId)
                                               .orElseThrow(() -> new RuntimeException("Leave quota not found for employee: " + employeeId));
        return LeaveQuotaMapper.toResponseDTO(quota);
    }

    /**
     * Returns all leave quotas (for admin view).
     */
    public List<LeaveQuotaResponseDTO> getAll() {
        return LeaveQuotaMapper.toResponseDTOList(leaveQuotaRepository.findAll());
    }
}
