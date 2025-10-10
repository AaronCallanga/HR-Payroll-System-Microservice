package com.hrps.attendanceservice.repository;

import com.hrps.attendanceservice.entity.LeaveQuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LeaveQuotaRepository extends JpaRepository<LeaveQuota, UUID> {
    Optional<LeaveQuota> findByEmployeeId(UUID employeeId);
}
