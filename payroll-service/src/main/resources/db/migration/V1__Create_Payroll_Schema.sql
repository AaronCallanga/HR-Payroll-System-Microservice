CREATE TABLE payroll (
    id BIGSERIAL PRIMARY KEY,
    employee_id UUID NOT NULL,                -- comes from Employee Service (via event)
    base_salary DECIMAL(12,2) NOT NULL,
    bonus DECIMAL(12,2) DEFAULT 0,
    deductions DECIMAL(12,2) DEFAULT 0,
    net_pay DECIMAL(12,2) NOT NULL,
    pay_period_start DATE NOT NULL,
    pay_period_end DATE NOT NULL,
    payment_date DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDING',           -- PENDING OR PAID
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);