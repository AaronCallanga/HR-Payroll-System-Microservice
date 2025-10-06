package com.hrps.payrollservice.repository;

import com.hrps.payrollservice.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
