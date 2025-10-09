package com.hrps.attendanceservice.mapper;

import com.hrps.attendanceservice.dto.response.LeaveQuotaResponseDTO;
import com.hrps.attendanceservice.entity.LeaveQuota;

import java.util.List;
import java.util.stream.Collectors;

public class LeaveQuotaMapper {

    /**
     * Converts LeaveQuota entity to LeaveQuotaResponse DTO.
     * Used for returning quota information to clients.
     * @param entity LeaveQuota entity from database
     * @return LeaveQuotaResponse DTO
     */
    public static LeaveQuotaResponseDTO toResponseDTO(LeaveQuota entity) {
        if (entity == null) return null;

        LeaveQuotaResponseDTO dto = new LeaveQuotaResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setTotalLeaves(entity.getTotalLeaves());
        dto.setUsedLeaves(entity.getUsedLeaves());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    /**
     * Converts LList<LeaveQuota> entities to LList<LeaveQuotaResponseDTO>.
     * Used for returning quota information to clients.
     * @param entities List of LeaveQuota entity from database
     * @return List of LeaveQuotaResponseDTO
     */
    public static List<LeaveQuotaResponseDTO> toResponseDTOList(List<LeaveQuota> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(LeaveQuotaMapper::toResponseDTO).collect(Collectors.toList());
    }
}
