package com.hrps.employeeservice;

import com.hrps.employeeservice.kafka.EmployeeEventProducer;
import com.hrps.employeeservice.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestRunenr implements CommandLineRunner {

    private final EmployeeEventProducer producer;

    public KafkaTestRunenr(EmployeeEventProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Sending test EmployeeEvent to Kafka...");
        producer.sendEmployeeCreatedEvent(new Employee());
        System.out.println("✅ Event sent successfully!");
    }
}
