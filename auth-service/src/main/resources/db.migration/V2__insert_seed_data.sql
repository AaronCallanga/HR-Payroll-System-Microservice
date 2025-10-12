-- Insert roles
INSERT INTO roles (name) VALUES
                             ('ROLE_USER'),
                             ('ROLE_ADMIN');

-- Insert users
INSERT INTO users (username, password, email)
VALUES
    ('admin', '{bcrypt}$2a$10$yqFwhPcR1uS4/3vVJpDbS.5wGgD6/.kwyAbRH9At0gq7AlzRBpt8O', 'admin@example.com'),
    ('testuser', '{bcrypt}$2a$10$J8N7yejRcdQ9wlVtDkTf4e1FqgnkIocv6VhFYRZy40o7QUnUp9AIW', 'user@example.com');

-- NOTE: both passwords are 'password' (bcrypt-hashed)

-- Assign roles
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'admin' AND r.name = 'ROLE_ADMIN';

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'testuser' AND r.name = 'ROLE_USER';
