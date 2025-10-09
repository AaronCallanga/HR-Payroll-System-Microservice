package com.hrps.attendanceservice.mapper;

import com.hrps.attendanceservice.dto.request.LeaveRequestDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestListResponseDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestResponseDTO;
import com.hrps.attendanceservice.entity.LeaveRequest;

import java.util.List;
import java.util.stream.Collectors;

public class LeaveRequestMapper {

    /**
     * Converts LeaveRequestRequest DTO to a LeaveRequest entity for saving to the database.
     * Sets default values for fields such as status and timestamps.
     * @param dto The incoming leave request from the API
     * @return LeaveRequest entity ready to be persisted
     */
    public static LeaveRequest toEntity(LeaveRequestDTO dto) {
        if (dto == null) return null;

        LeaveRequest entity = new LeaveRequest();
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setLeaveType(dto.getLeaveType());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setReason(dto.getReason());
        return entity;
    }

    /**
     * Converts a LeaveRequest entity to its corresponding response DTO.
     * Used for returning data to the client (API).
     * @param entity LeaveRequest entity from database
     * @return LeaveRequestResponse containing full leave request info
     */
    public static LeaveRequestResponseDTO toResponseDTO(LeaveRequest entity) {
        if (entity == null) return null;

        LeaveRequestResponseDTO dto = new LeaveRequestResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setLeaveType(entity.getLeaveType());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setTotalDays(entity.getTotalDays() != null ? entity.getTotalDays() : 0);
        dto.setReason(entity.getReason());
        dto.setStatus(entity.getStatus());
        dto.setApprover(entity.getApprover());
        dto.setDecisionDate(entity.getDecisionDate());
        return dto;
    }

    /**
     * Converts a LeaveRequest entity to LeaveRequestListResponseDTO for List items.
     * Used for setting up returning a compacted List of LeaveRequest response DTO
     * @param entity LeaveRequest entity from database
     * @return LeaveRequestListResponseDTO containing full leave request info
     */
    public static LeaveRequestListResponseDTO toListResponseDTO(LeaveRequest entity) {
        if (entity == null) return null;

        LeaveRequestListResponseDTO dto = new LeaveRequestListResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setLeaveType(entity.getLeaveType());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    /**
     * Converts a LeaveRequest entity to List<LeaveRequestListResponseDTO>.
     * Used for returning compacted leave request list to the client (API).
     * @param entities List of LeaveRequest entity from database
     * @return List of LeaveRequestListResponseDTO containing full leave request info
     */
    public static List<LeaveRequestListResponseDTO> toListResponseDTOList(List<LeaveRequest> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(LeaveRequestMapper::toListResponseDTO).collect(Collectors.toList());
    }

    /**
     * Converts a LeaveRequest entities to List<LeaveRequestResponseDTO>.
     * Used for returning detailed leave request list to the client (API).
     * @param entities List of LeaveRequest entity from database
     * @return List of LeaveRequestResponseDTO containing full leave request info
     */
    public static List<LeaveRequestResponseDTO> toResponseDTOList(List<LeaveRequest> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(LeaveRequestMapper::toResponseDTO).collect(Collectors.toList());
    }
}