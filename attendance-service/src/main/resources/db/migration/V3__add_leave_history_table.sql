-- ============================================
-- LEAVE HISTORY TABLE
-- ============================================

CREATE TABLE leave_history (
                               id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                               employee_id UUID NOT NULL,
                               leave_type VARCHAR(50) NOT NULL,         -- e.g., Vacation, Sick, Emergency
                               start_date DATE NOT NULL,
                               end_date DATE NOT NULL,
                               total_days INT GENERATED ALWAYS AS (end_date - start_date + 1) STORED,
                               reason TEXT,
                               status VARCHAR(20) NOT NULL DEFAULT 'APPROVED', -- record of completed leaves
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Index for quick employee-based filtering
CREATE INDEX idx_leave_history_employee_id ON leave_history(employee_id);
