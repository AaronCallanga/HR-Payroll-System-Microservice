-- ============================================
-- LEAVE REQUEST TABLE
-- ============================================

CREATE TABLE leave_request (
                               id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                               employee_id UUID NOT NULL,
                               leave_type VARCHAR(50) NOT NULL,          -- e.g., Vacation, Sick, Emergency
                               start_date DATE NOT NULL,
                               end_date DATE NOT NULL,
                               total_days INT GENERATED ALWAYS AS (end_date - start_date + 1) STORED,
                               reason TEXT,
                               status VARCHAR(20) NOT NULL DEFAULT 'PENDING',  -- PENDING, APPROVED, REJECTED
                               approver VARCHAR(100),
                               decision_date TIMESTAMP,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Index for employee queries
CREATE INDEX idx_leave_request_employee_id ON leave_request(employee_id);
