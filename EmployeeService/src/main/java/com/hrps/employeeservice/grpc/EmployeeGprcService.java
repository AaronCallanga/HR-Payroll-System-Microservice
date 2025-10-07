package com.hrps.employeeservice.grpc;

import com.hrps.employeeservice.model.Employee;
import com.hrps.employeeservice.repository.EmployeeRepository;
import employee.EmployeeListResponse;
import employee.EmployeeRequest;
import employee.EmployeeResponse;
import employee.EmployeeServiceGrpc;
import employee.EmptyRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class EmployeeGprcService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    private final EmployeeRepository employeeRepository;

    public EmployeeGprcService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void getEmployeeById(EmployeeRequest request, StreamObserver<EmployeeResponse> responseObserver) {
        Employee employee = employeeRepository.findById(UUID.fromString(request.getId()))
                .orElseThrow(() -> new RuntimeException("Employee not found"));


    }

    @Override
    public void getAllEmployeeList(EmptyRequest request, StreamObserver<EmployeeListResponse> responseObserver) {
        super.getAllEmployeeList(request, responseObserver);
    }
}
