package com.hrps.attendanceservice.service;

import com.hrps.attendanceservice.dto.request.LeaveRequestRequestDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestListResponseDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestResponseDTO;
import com.hrps.attendanceservice.entity.LeaveRequest;
import com.hrps.attendanceservice.mapper.LeaveRequestMapper;
import com.hrps.attendanceservice.repository.LeaveRequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    /**
     * Submits a new leave request by an employee.
     */
    // Should send event
    public LeaveRequestResponseDTO submitRequest(LeaveRequestRequestDTO dto) {
        LeaveRequest entity = LeaveRequestMapper.toEntity(dto);
        LeaveRequest saved = leaveRequestRepository.save(entity);
        return LeaveRequestMapper.toResponseDTO(saved);
    }

    /**
     * Approves or rejects a leave request.
     */
    // Should send event (to notify the employee by email, etc)
    // Send async call for leave history to log it (or consume event? ask for design)
    public LeaveRequestResponseDTO updateStatus(UUID requestId, String status, String approver) {
        LeaveRequest request = leaveRequestRepository.findById(requestId)
                                                     .orElseThrow(() -> new RuntimeException("Leave request not found: " + requestId));

        request.setStatus(status);
        request.setApprover(approver);
        request.setDecisionDate(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());

        LeaveRequest saved = leaveRequestRepository.save(request);
        return LeaveRequestMapper.toResponseDTO(saved);
    }

    /**
     * Retrieves all leave requests for a specific employee.
     */
    public List<LeaveRequestListResponseDTO> getByEmployee(UUID employeeId) {
        return LeaveRequestMapper.toListResponseDTOList(leaveRequestRepository.findByEmployeeId(employeeId));
    }

    /**
     * Retrieves all leave requests (for HR view).
     */
    public List<LeaveRequestListResponseDTO> getAll() {
        return LeaveRequestMapper.toListResponseDTOList(leaveRequestRepository.findAll());
    }
}
