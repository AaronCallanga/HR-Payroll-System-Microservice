-- ============================================
-- PERFORMANCE REVIEW TABLE
-- ============================================
CREATE TABLE performance_review (
                                    id SERIAL PRIMARY KEY,
                                    employee_id UUID NOT NULL,
                                    review_period VARCHAR(50) DEFAULT 'Initial Evaluation',
                                    reviewer VARCHAR(100),
                                    score NUMERIC(3, 2),
                                    comments TEXT,
                                    status VARCHAR(20) DEFAULT 'PENDING',
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
