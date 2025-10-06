package com.hrps.employeeservice.kafka;

import com.hrps.avro.employee.EmployeeEvent;
import com.hrps.employeeservice.model.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeEventProducer {
    private final KafkaTemplate<String, EmployeeEvent> kafkaTemplate;
    private static final String TOPIC = "employee.events";

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

        kafkaTemplate.send(TOPIC, event.getId().toString(), event);
        System.out.println("✅ Sent EmployeeEvent to Kafka: " + event);
    }
}
