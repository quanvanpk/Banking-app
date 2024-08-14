-- V1__create_tables.sql

-- Create roles table
CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

-- Create users table
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    roles BIGINT,
    FOREIGN KEY (roles) REFERENCES roles(id) ON DELETE SET NULL
);

-- Create account_types table
CREATE TABLE account_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

-- Create accounts table
CREATE TABLE accounts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(20) NOT NULL UNIQUE,
    user_id BIGINT NOT NULL,
    account_type_id BIGINT NOT NULL,
    balance DECIMAL(19, 2) DEFAULT 0.00,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (account_type_id) REFERENCES account_types(id) ON DELETE RESTRICT
);

-- Create transaction_types table
CREATE TABLE transaction_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

-- Create transactions table
CREATE TABLE transactions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_id BIGINT NOT NULL,
    transaction_type_id BIGINT NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE,
    FOREIGN KEY (transaction_type_id) REFERENCES transaction_types(id) ON DELETE RESTRICT
);
