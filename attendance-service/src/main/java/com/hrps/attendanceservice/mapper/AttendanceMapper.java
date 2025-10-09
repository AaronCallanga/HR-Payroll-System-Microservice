package com.hrps.attendanceservice.mapper;

import com.hrps.attendanceservice.dto.request.AttendanceRequestDTO;
import com.hrps.attendanceservice.dto.response.AttendanceResponseDTO;
import com.hrps.attendanceservice.entity.AttendanceRecord;

import java.util.List;
import java.util.stream.Collectors;

public class AttendanceMapper {
    /**
     * Converts AttendanceRequest DTO to an AttendanceRecord entity.
     * Default values are applied for date and status.
     * @param dto API request payload containing attendance details
     * @return AttendanceRecord entity ready for persistence
     */
    public static AttendanceRecord toEntity(AttendanceRequestDTO dto) {
        if (dto == null) return null;

        AttendanceRecord entity = new AttendanceRecord();
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setAttendanceDate(dto.getAttendanceDate());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    /**
     * Converts AttendanceRecord entity to AttendanceResponse DTO.
     * Used for returning formatted attendance information in responses.
     * @param entity AttendanceRecord entity from DB
     * @return AttendanceResponse DTO for API response
     */
    public static AttendanceResponseDTO toResponseDTO(AttendanceRecord entity) {
        if (entity == null) return null;

        AttendanceResponseDTO dto = new AttendanceResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setAttendanceDate(entity.getAttendanceDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    /**
     * Converts List<AttendanceRecord> entities to List<AttendanceResponseDTO>.
     * Used for returning list items of AttendanceResponseDTO.
     * @param entities List of AttendanceRecord entity from DB
     * @return List of AttendanceResponseDTO for API response
     */
    public static List<AttendanceResponseDTO> toResponseDTOList(List<AttendanceRecord> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(AttendanceMapper::toResponseDTO).collect(Collectors.toList());
    }
}
