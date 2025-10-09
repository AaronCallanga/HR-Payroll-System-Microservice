package com.hrps.attendanceservice.repository;

import com.hrps.attendanceservice.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, UUID> {
}
