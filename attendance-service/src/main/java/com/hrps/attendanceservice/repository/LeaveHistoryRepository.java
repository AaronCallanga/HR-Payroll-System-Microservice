package com.hrps.attendanceservice.repository;

import com.hrps.attendanceservice.entity.LeaveHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, UUID> {
    List<LeaveHistory> findByEmployeeId(UUID employeeId);
}
