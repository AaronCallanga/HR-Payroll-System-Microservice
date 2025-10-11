package com.hrps.notificationservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import com.hrps.notificationservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(EmployeeEventConsumer.class);
    private final EmailService emailService;

    public EmployeeEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "employee.events.created", groupId = "notification-consumer-group")
    public void handleEmployeeCreated(EmployeeEvent event) {
        log.info("Received employee event: " + event);
        emailService.sendWelcomeEmail(event.getEmail().toString(), event.getFirstName().toString());
    }
}
