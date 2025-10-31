package com.hrps.employeeservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import com.hrps.employeeservice.model.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeEventProducer {
    private final KafkaTemplate<String, EmployeeEvent> kafkaTemplate;
    // <domain>.<entity>.<action> -> topic naming convention
    private static final String CREATED_TOPIC = "employee.events.created";
    private static final String UPDATED_TOPIC = "employee.events.updated";

    public EmployeeEventProducer(KafkaTemplate<String, EmployeeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployeeCreatedEvent(Employee employee) {
        EmployeeEvent event = EmployeeEvent.newBuilder()
                                           .setId(employee.getId().toString())
                                           .setFirstName(employee.getFirstName())
                                           .setLastName(employee.getLastName())
                                           .setEmail(employee.getEmail())
                                           .setDepartmentName(employee.getDepartment().getName())
                                           .setEventType(EmployeeEventType.CREATED.name())
                                           .build();

        kafkaTemplate.send(CREATED_TOPIC, event.getId().toString(), event);
        System.out.println("✅ Sent EmployeeEvent to Kafka: " + event);
    }

    public void sendEmployeeUpdateEvent(Employee employee) {
        EmployeeEvent event = EmployeeEvent.newBuilder()
                                           .setId(employee.getId().toString())
                                           .setFirstName(employee.getFirstName())
                                           .setLastName(employee.getLastName())
                                           .setEmail(employee.getEmail())
                                           .setDepartmentName(employee.getDepartment().getName())
                                           .setEventType(EmployeeEventType.UPDATED.name())
                                           .build();

        kafkaTemplate.send(UPDATED_TOPIC, event.getId().toString(), event);
        System.out.println("✅ Sent EmployeeEvent to Kafka: " + event);
    }
}
