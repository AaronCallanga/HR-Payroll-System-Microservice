-- Insert sample departments
INSERT INTO department (name, description)
VALUES
    ('Human Resources', 'Handles recruitment, employee relations, and compliance.'),
    ('Engineering', 'Responsible for software development and infrastructure.'),
    ('Finance', 'Manages payroll, budgets, and company finances.'),
    ('Marketing', 'Oversees advertising, brand strategy, and promotions.');

-- Insert sample employees
INSERT INTO employee (first_name, last_name, email, phone_number, hire_date, role, salary, department_id)
VALUES
    ('Jane', 'Doe', 'jane.doe@company.com', '09171234567', '2022-06-10', 'HR Manager', 55000.00, 1),
    ('John', 'Smith', 'john.smith@company.com', '09281234567', '2021-03-15', 'Software Engineer', 70000.00, 2),
    ('Alice', 'Garcia', 'alice.garcia@company.com', '09981234567', '2023-01-20', 'Finance Officer', 50000.00, 3),
    ('Robert', 'Tan', 'robert.tan@company.com', '09181234567', '2020-10-05', 'Marketing Specialist', 45000.00, 4);
