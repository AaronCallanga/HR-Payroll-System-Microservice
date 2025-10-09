package com.hrps.attendanceservice.mapper;

import com.hrps.attendanceservice.dto.request.AttendanceRequestDTO;
import com.hrps.attendanceservice.dto.response.AttendanceResponseDTO;
import com.hrps.attendanceservice.entity.AttendanceRecord;

import java.util.List;
import java.util.stream.Collectors;

public class AttendanceMapper {
    public static AttendanceRecord toEntity(AttendanceRequestDTO dto) {
        if (dto == null) return null;

        AttendanceRecord entity = new AttendanceRecord();
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setAttendanceDate(dto.getAttendanceDate());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public static AttendanceResponseDTO toResponseDTO(AttendanceRecord entity) {
        if (entity == null) return null;

        AttendanceResponseDTO dto = new AttendanceResponseDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setAttendanceDate(entity.getAttendanceDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<AttendanceResponseDTO> toResponseDTOList(List<AttendanceRecord> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(AttendanceMapper::toResponseDTO).collect(Collectors.toList());
    }
}
