CREATE TABLE towns(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE addresses(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    address_text TEXT NOT NULL,
    town_id INT NOT NULL,
    CONSTRAINT fk_addresses_towns FOREIGN KEY (town_id) REFERENCES towns (id)
);

CREATE TABLE departments(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    job_title VARCHAR(30) NOT NULL,
    department_id INT NOT NULL,
    hire_date DATE NOT NULL,
    salary INT NOT NULL,
    address_id INT NOT NULL,
    CONSTRAINT fk_employees_department FOREIGN KEY (department_id) REFERENCES departments (id),
    CONSTRAINT fk_employees_address FOREIGN KEY (address_id) REFERENCES addresses (id)
);