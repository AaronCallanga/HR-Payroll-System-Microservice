-- Enable UUID extension (important for UUID generation in PostgreSQL)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ============================================
-- DEPARTMENT TABLE
-- ============================================
CREATE TABLE department (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            description TEXT,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- EMPLOYEE TABLE
-- ============================================
CREATE TABLE employee (
                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100) NOT NULL,
                          email VARCHAR(150) UNIQUE NOT NULL,
                          phone_number VARCHAR(20),
                          hire_date DATE NOT NULL,
                          role VARCHAR(100),
                          salary NUMERIC(12, 2),
                          department_id INT REFERENCES department(id) ON DELETE SET NULL,
                          status VARCHAR(20) DEFAULT 'ACTIVE',
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
