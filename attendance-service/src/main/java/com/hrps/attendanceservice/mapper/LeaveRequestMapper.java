package com.hrps.attendanceservice.mapper;

import com.hrps.attendanceservice.dto.request.LeaveRequestDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestListResponseDTO;
import com.hrps.attendanceservice.dto.response.LeaveRequestResponseDTO;
import com.hrps.attendanceservice.entity.LeaveRequest;

import java.util.List;
import java.util.stream.Collectors;

public class LeaveRequestMapper {

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

    public static List<LeaveRequestListResponseDTO> toListResponseDTOList(List<LeaveRequest> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(LeaveRequestMapper::toListResponseDTO).collect(Collectors.toList());
    }

    public static List<LeaveRequestResponseDTO> toResponseDTOList(List<LeaveRequest> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(LeaveRequestMapper::toResponseDTO).collect(Collectors.toList());
    }
}