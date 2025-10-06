-- Insert sample payroll data for September 2025 pay period

INSERT INTO payroll (
    employee_id,
    base_salary,
    bonus,
    deductions,
    net_pay,
    pay_period_start,
    pay_period_end,
    payment_date,
    status
)
VALUES
    -- Jane Doe (HR Manager)
    ('b7983e47-785c-4936-bc8a-426fc49af3d7',
     55000.00, 2000.00, 500.00,
     56500.00, '2025-09-01', '2025-09-30', '2025-10-01', 'PAID'),

    -- John Smith (Software Engineer)
    ('15ebf051-b064-46f2-83ff-19122692b144',
     70000.00, 5000.00, 1000.00,
     74000.00, '2025-09-01', '2025-09-30', '2025-10-01', 'PAID'),

    -- Alice Garcia (Finance Officer)
    ('d9cab7ad-8f20-4017-8e4f-9639f06f5bfd',
     50000.00, 1500.00, 300.00,
     51200.00, '2025-09-01', '2025-09-30', '2025-10-01', 'PAID'),

    -- Robert Tan (Marketing Specialist)
    ('1c17f448-c4b1-4e18-8f14-dc3b0235f661',
     45000.00, 1000.00, 400.00,
     45600.00, '2025-09-01', '2025-09-30', '2025-10-01', 'PAID');
