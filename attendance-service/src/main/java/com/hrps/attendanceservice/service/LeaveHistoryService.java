package com.hrps.attendanceservice.service;

import com.hrps.attendanceservice.dto.response.LeaveHistoryResponseDTO;
import com.hrps.attendanceservice.entity.LeaveHistory;
import com.hrps.attendanceservice.mapper.LeaveHistoryMapper;
import com.hrps.attendanceservice.repository.LeaveHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeaveHistoryService {

    private final LeaveHistoryRepository leaveHistoryRepository;

    public LeaveHistoryService(LeaveHistoryRepository leaveHistoryRepository) {
        this.leaveHistoryRepository = leaveHistoryRepository;
    }

    /**
     * Logs a leave to history after approval. / Update the history after "APPROVED"
     */
    public LeaveHistoryResponseDTO logLeave(LeaveHistory entity) {
        LeaveHistory saved = leaveHistoryRepository.save(entity);
        return LeaveHistoryMapper.toResponseDTO(saved);
    }

    /**
     * Retrieves all historical leaves of an employee.
     */
    public List<LeaveHistoryResponseDTO> getByEmployee(UUID employeeId) {
        return LeaveHistoryMapper.toResponseDTOList(leaveHistoryRepository.findByEmployeeId(employeeId));
    }

    /**
     * Returns all leave history records (for admin or reports).
     */
    public List<LeaveHistoryResponseDTO> getAll() {
        return LeaveHistoryMapper.toResponseDTOList(leaveHistoryRepository.findAll());
    }
}
