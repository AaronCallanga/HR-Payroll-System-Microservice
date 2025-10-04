package com.hrps.employeeservice.kafka;

import com.hrps.employeeservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(EmployeeKafkaProducer.class);
    // Value is byte[] because we are using proto message as the value/dto/event but you can do event classes
    // byte data type - to keep the size of the message down, and easier to convert to object (for consumers)
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public EmployeeKafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployeeCreated(Employee employee) {

    }

}
