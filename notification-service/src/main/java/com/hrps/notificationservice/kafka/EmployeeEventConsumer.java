package com.hrps.notificationservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import com.hrps.notificationservice.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventConsumer {

    private final EmailService emailService;

    public EmployeeEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "employee.events", groupId = "notification-consumer-group")
    public void handleEmployeeCreated(EmployeeEvent event) {
        emailService.sendWelcomeEmail(event.getEmail().toString(), event.getFirstName().toString());
    }
}
