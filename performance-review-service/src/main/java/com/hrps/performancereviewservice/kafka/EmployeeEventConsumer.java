package com.hrps.performancereviewservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import com.hrps.performancereviewservice.service.PerformanceReviewService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeEventConsumer {

    private final PerformanceReviewService performanceReviewService;

    public EmployeeEventConsumer(PerformanceReviewService performanceReviewService) {
        this.performanceReviewService = performanceReviewService;
    }

    @KafkaListener(topics = "employee.events", groupId = "performance-review-consumer-group")
    public void handleEmployeeCreated(EmployeeEvent employeeEvent) {
        performanceReviewService.initializePerformanceReview(UUID.fromString(employeeEvent.getId().toString()));
    }
}
