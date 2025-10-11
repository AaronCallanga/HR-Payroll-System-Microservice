package com.hrps.performancereviewservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import com.hrps.performancereviewservice.service.PerformanceReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(EmployeeEventConsumer.class);
    private final PerformanceReviewService performanceReviewService;

    public EmployeeEventConsumer(PerformanceReviewService performanceReviewService) {
        this.performanceReviewService = performanceReviewService;
    }

    @KafkaListener(topics = "employee.events.created", groupId = "performance-review-consumer-group")
    public void handleEmployeeCreated(EmployeeEvent employeeEvent) {
        log.info("Employee event received: " + employeeEvent);
        performanceReviewService.initializePerformanceReview(UUID.fromString(employeeEvent.getId().toString()));
    }
}
