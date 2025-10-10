package com.hrps.payrollservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventConsumer {

    @KafkaListener(topics = "employee.events.created", groupId = "payroll-consumer-group")
    public void consume(EmployeeEvent event) {
        System.out.println("📩 Received EmployeeEvent from Kafka:");
        System.out.println("🧍 ID: " + event.getId());
        System.out.println("👤 Name: " + event.getFirstName() + " " + event.getLastName());
        System.out.println("📧 Email: " + event.getEmail());
        System.out.println("🏢 Department: " + event.getDepartmentName());
        System.out.println("📅 Event Type: " + event.getEventType());

        // Create payroll account
        // maybe talk gRPC with the employee service for more entity information
    }
}
