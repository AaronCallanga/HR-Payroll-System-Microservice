-- ============================================
-- SEED DATA FOR PERFORMANCE REVIEW TABLE
-- ============================================

INSERT INTO performance_review (employee_id, review_period, reviewer, score, comments, status, created_at, updated_at)
VALUES
-- Initial Evaluation for new employee
('b7983e47-785c-4936-bc8a-426fc49af3d7', 'Initial Evaluation', 'HR System', 0.00, 'Auto-generated initial review record', 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Probation Review after 3 months
('15ebf051-b064-46f2-83ff-19122692b144', 'Probation Review', 'Jane HR', 3.50, 'Shows good potential but needs improvement in communication', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Mid-Year Review
('d9cab7ad-8f20-4017-8e4f-9639f06f5bfd', 'Mid-Year Review', 'John Manager', 4.20, 'Exceeds expectations on recent projects', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Annual Review (in progress)
('1c17f448-c4b1-4e18-8f14-dc3b0235f661', 'Annual Review', 'Sarah Lead', 0.00, 'Review in progress', 'IN_PROGRESS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Project-Based Review (on hold)
('a4457f7f-3394-471d-bcf7-005e44fdb5df', 'Project-Based Review', 'Team Supervisor', 0.00, 'Project delayed due to external factors', 'ON_HOLD', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
