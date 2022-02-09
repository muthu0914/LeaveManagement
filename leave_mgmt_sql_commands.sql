-- Create Database
CREATE DATABASE hr_portal
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_IN'
    LC_CTYPE = 'en_IN'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
-- Create Employee Management Schema
CREATE SCHEMA employee_mgmt
    AUTHORIZATION postgres;

-- Create Leave Management Schema
CREATE SCHEMA leave_mgmt
    AUTHORIZATION postgres;

-- Table: employee_mgmt.employee_master

CREATE TABLE IF NOT EXISTS employee_mgmt.employee_master
(
    employee_id numeric NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    email_id text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employee_master_pkey PRIMARY KEY (employee_id)
);

-- Table: employee_mgmt.employee_relation

CREATE TABLE IF NOT EXISTS employee_mgmt.employee_relation
(
    employee_id numeric NOT NULL,
    manager_employee_id numeric
);

-- Table: leave_mgmt.leave_info

CREATE TABLE IF NOT EXISTS leave_mgmt.leave_info
(
    leave_id text COLLATE pg_catalog."default" NOT NULL,
    employee_id numeric NOT NULL,
    leave_type text COLLATE pg_catalog."default" NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    reason text COLLATE pg_catalog."default" NOT NULL,
    leave_status text COLLATE pg_catalog."default" NOT NULL,
    manager_employee_id numeric,
    CONSTRAINT leave_info_pkey PRIMARY KEY (leave_id)
);

-- Sample data for employee_mgmt.employee_master

INSERT INTO employee_mgmt.employee_master (employee_id, name, email_id) VALUES (100, 'CEO', 'ceo@gmail.com');
INSERT INTO employee_mgmt.employee_master (employee_id, name, email_id) VALUES (200, 'Manager 1', 'manager1@gmail.com');
INSERT INTO employee_mgmt.employee_master (employee_id, name, email_id) VALUES (201, 'Manager 2', 'manager2@gmail.com');
INSERT INTO employee_mgmt.employee_master (employee_id, name, email_id) VALUES (300, 'Employee 1', 'employee1@gmail.com');
INSERT INTO employee_mgmt.employee_master (employee_id, name, email_id) VALUES (301, 'Employee 2', 'employee2@gmail.com');
INSERT INTO employee_mgmt.employee_master (employee_id, name, email_id) VALUES (302, 'Employee 3', 'employee3@gmail.com');

-- Sample data for employee_mgmt.employee_relation

INSERT INTO employee_mgmt.employee_relation (employee_id, manager_employee_id) VALUES (100, NULL);
INSERT INTO employee_mgmt.employee_relation (employee_id, manager_employee_id) VALUES (200, 100);
INSERT INTO employee_mgmt.employee_relation (employee_id, manager_employee_id) VALUES (201, 100);
INSERT INTO employee_mgmt.employee_relation (employee_id, manager_employee_id) VALUES (300, 200);
INSERT INTO employee_mgmt.employee_relation (employee_id, manager_employee_id) VALUES (301, 200);
INSERT INTO employee_mgmt.employee_relation (employee_id, manager_employee_id) VALUES (302, 201);
