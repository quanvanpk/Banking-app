-- Insert data into roles table
INSERT INTO roles (name) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

-- Insert data into users table
INSERT INTO users (username, password, email, roles) VALUES
('quanvan', 'password_hash_1', 'quanvan@example.com', 1),
('quanvan_admin', 'password_hash_2', 'quanvanadmin@example.com', 2);

-- Insert data into account_types table
INSERT INTO account_types (name) VALUES
('SAVINGS'),
('CHECKING');

-- Insert data into accounts table
INSERT INTO accounts (account_number, user_id, account_type_id, balance) VALUES
('1234567890', 1, 1, 1000.00),
('0987654321', 2, 2, 2500.00);

-- Insert data into transaction_types table
INSERT INTO transaction_types (name) VALUES
('DEPOSIT'),
('WITHDRAWAL');

-- Insert data into transactions table
INSERT INTO transactions (account_id, transaction_type_id, amount) VALUES
(1, 1, 500.00),
(2, 2, 1000.00);
