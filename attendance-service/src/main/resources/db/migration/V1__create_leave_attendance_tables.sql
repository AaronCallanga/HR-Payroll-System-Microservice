-- Enable UUID extension (important for UUID generation in PostgreSQL)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ============================================
-- LEAVE QUOTA TABLE
-- ============================================
CREATE TABLE leave_quota (
                             id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                             employee_id UUID NOT NULL, -- reference to Employee Service
                             total_leaves INT NOT NULL DEFAULT 15, -- default annual quota
                             used_leaves INT NOT NULL DEFAULT 0,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Optional: Index for faster lookups by employee_id
CREATE INDEX idx_leave_quota_employee_id ON leave_quota(employee_id);

-- ============================================
-- ATTENDANCE RECORD TABLE
-- ============================================
CREATE TABLE attendance_record (
                                   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                   employee_id UUID NOT NULL, -- reference to Employee Service
                                   attendance_date DATE NOT NULL DEFAULT CURRENT_DATE,
                                   status VARCHAR(20) DEFAULT 'PENDING', -- e.g., PRESENT, ABSENT, PENDING
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Optional: Index for faster lookups by employee_id
CREATE INDEX idx_attendance_employee_id ON attendance_record(employee_id);