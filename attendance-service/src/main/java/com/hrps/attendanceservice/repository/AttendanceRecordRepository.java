package com.hrps.attendanceservice.repository;

import com.hrps.attendanceservice.entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, UUID> {
}
