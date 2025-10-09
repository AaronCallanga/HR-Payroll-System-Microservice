-- ============================================
-- SAMPLE DATA FOR LEAVE HISTORY AND LEAVE REQUEST
-- ============================================

-- LEAVE HISTORY (Approved Past Leaves)
INSERT INTO leave_history (employee_id, leave_type, start_date, end_date, reason, status)
VALUES
    ('b7983e47-785c-4936-bc8a-426fc49af3d7', 'Vacation', '2025-03-10', '2025-03-14', 'Family trip', 'APPROVED'),
    ('15ebf051-b064-46f2-83ff-19122692b144', 'Sick Leave', '2025-04-02', '2025-04-03', 'Flu recovery', 'APPROVED'),
    ('d9cab7ad-8f20-4017-8e4f-9639f06f5bfd', 'Emergency Leave', '2025-05-01', '2025-05-02', 'Urgent family matter', 'APPROVED'),
    ('1c17f448-c4b1-4e18-8f14-dc3b0235f661', 'Vacation', '2025-06-15', '2025-06-20', 'Summer holiday', 'APPROVED');

-- LEAVE REQUESTS (Pending / In Progress)
INSERT INTO leave_request (employee_id, leave_type, start_date, end_date, reason, status, approver)
VALUES
    ('b7983e47-785c-4936-bc8a-426fc49af3d7', 'Sick Leave', '2025-10-09', '2025-10-10', 'Fever and rest needed', 'PENDING', NULL),
    ('15ebf051-b064-46f2-83ff-19122692b144', 'Vacation', '2025-11-01', '2025-11-05', 'Family visit', 'PENDING', NULL),
    ('d9cab7ad-8f20-4017-8e4f-9639f06f5bfd', 'Emergency Leave', '2025-09-28', '2025-09-29', 'House repair', 'APPROVED', 'HR Manager'),
    ('1c17f448-c4b1-4e18-8f14-dc3b0235f661', 'Vacation', '2025-12-10', '2025-12-14', 'Year-end rest', 'REJECTED', 'Team Lead');
