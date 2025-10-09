package com.hrps.attendanceservice.mapper;

import com.hrps.attendanceservice.dto.response.LeaveHistoryResponseDTO;
import com.hrps.attendanceservice.entity.LeaveHistory;

import java.util.List;
import java.util.stream.Collectors;

public class LeaveHistoryMapper {

    public static LeaveHistoryResponseDTO toResponseDTO(LeaveHistory entity) {
        if (entity == null) return null;

        LeaveHistoryResponseDTO dto = new LeaveHistoryResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setLeaveType(entity.getLeaveType());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setTotalDays(entity.getTotalDays());
        dto.setReason(entity.getReason());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<LeaveHistoryResponseDTO> toResponseDTOList(List<LeaveHistory> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(LeaveHistoryMapper::toResponseDTO).collect(Collectors.toList());
    }
}
