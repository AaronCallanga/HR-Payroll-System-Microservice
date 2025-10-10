package com.hrps.attendanceservice.kafka;

import com.hrps.attendanceservice.service.LeaveQuotaService;
import com.hrps.avro.employee.EmployeeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeEventConsumer {

    private final LeaveQuotaService leaveQuotaService;

    public EmployeeEventConsumer(LeaveQuotaService leaveQuotaService) {
        this.leaveQuotaService = leaveQuotaService;
    }

    @KafkaListener(topics = "employee.events.created", groupId = "attendance-consumer-group")
    public void handleEmployeeCreated(EmployeeEvent employeeEvent) {
        leaveQuotaService.initializeLeaveQuota(UUID.fromString(employeeEvent.getId().toString()));
    }

}
