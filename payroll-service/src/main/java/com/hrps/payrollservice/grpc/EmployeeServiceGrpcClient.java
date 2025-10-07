package com.hrps.payrollservice.grpc;

import employee.EmployeeRequest;
import employee.EmployeeResponse;
import employee.EmployeeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeServiceGrpcClient {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceGrpcClient.class);

    private final EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;

    public EmployeeServiceGrpcClient(@Value("${employee.service.address:localhost}") String serverAddress,
                                    @Value("${employee.service.grpc.port:9090}") int serverPort) {
        log.info("Connecting to Employee Service gRPC server at {}:{}", serverAddress, serverPort);
        // 1. Create channel to BillingService
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                                                      .usePlaintext() // disables TLS (dev only)
                                                      .build();
        // 2. Create blocking stub (synchronous calls)
        this.blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
    }

    public EmployeeResponse getEmployee(UUID employeeId) {
        // 3. Build request
        EmployeeRequest request = EmployeeRequest.newBuilder()
                .setId(employeeId.toString())
                .build();

        // 4. Call remote gRPC method
        EmployeeResponse response = blockingStub.getEmployeeById(request);
        log.info("Received response from Billing-Service via gRPC {}", response);
        return response;
    }

}
