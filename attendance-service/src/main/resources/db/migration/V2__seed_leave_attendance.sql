-- ============================================
-- SEED INITIAL LEAVE QUOTA AND ATTENDANCE DATA
-- ============================================

-- Insert Leave Quota Records
INSERT INTO leave_quota (employee_id, total_leaves, used_leaves)
VALUES
    ('b7983e47-785c-4936-bc8a-426fc49af3d7', 15, 0),
    ('15ebf051-b064-46f2-83ff-19122692b144', 15, 0),
    ('d9cab7ad-8f20-4017-8e4f-9639f06f5bfd', 15, 0),
    ('1c17f448-c4b1-4e18-8f14-dc3b0235f661', 15, 0);

-- Insert Attendance Records
INSERT INTO attendance_record (employee_id, attendance_date, status)
VALUES
    ('b7983e47-785c-4936-bc8a-426fc49af3d7', CURRENT_DATE, 'PENDING'),
    ('15ebf051-b064-46f2-83ff-19122692b144', CURRENT_DATE, 'PENDING'),
    ('d9cab7ad-8f20-4017-8e4f-9639f06f5bfd', CURRENT_DATE, 'PENDING'),
    ('1c17f448-c4b1-4e18-8f14-dc3b0235f661', CURRENT_DATE, 'PENDING');
