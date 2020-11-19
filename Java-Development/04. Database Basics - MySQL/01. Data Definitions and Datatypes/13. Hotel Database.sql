CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    title VARCHAR(50),
    notes TEXT
);

INSERT INTO employees VALUES
(1, 'Deyan', 'Dimitrov', 'Software Engineer', 'has a car'),
(2, 'Iliqn', 'Ilkov', 'Web Developer', 'has`n got a car'),
(3, 'Georgi', 'Kozev', 'Delivery guy', 'has a car');


CREATE TABLE customers(
	account_number INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    phone_number INT,
    emergency_name VARCHAR(30),
    emergency_number INT,
    notes TEXT
);

INSERT INTO customers VALUES
(1, 'Deyan', 'Dimitrov', 0877111333, NULL, NULL, 'EMPTY'),
(2, 'Iliqn', 'Ilkov', 0872343232, 'Iliya', '055344555', 'none'),
(3, 'Georgi', 'Kozev', 0899123854, NULL, NULL, 'call me');


CREATE TABLE room_status(
    room_status VARCHAR(50) PRIMARY KEY NOT NULL,
    notes TEXT
);

INSERT INTO room_status VALUES
('free', 'please clean it'),
('busy', 'do not disturb'),
('done', 'none');


CREATE TABLE room_types(
    room_type VARCHAR(50) PRIMARY KEY NOT NULL,
    notes TEXT
);

INSERT INTO room_types VALUES
('2 persons', 'please clean it'),
('3 persons', 'extra bed'),
('Apartment', 'none');


CREATE TABLE bed_types(
    bed_type VARCHAR(50) PRIMARY KEY NOT NULL,
    notes TEXT
);

INSERT INTO bed_types VALUES
('kid', 'not so big'),
('single', ''),
('couple', NULL);


CREATE TABLE rooms(
	room_number INT(11) PRIMARY KEY NOT NULL,
    room_type ENUM ('2 persons', '3 persons', 'Apartment') NOT NULL,
    bed_type ENUM ('single', 'couple', 'kid') NOT NULL,
    rate DOUBLE(5,2),
    room_status ENUM ('free', 'busy') NOT NULL,
    notes TEXT
);

INSERT INTO rooms VALUES
(112, '2 persons', 'single', 38, 'busy', NULL),
(202, '3 persons', 'single', 50,'busy', NULL),
(303, '3 persons', 'single', 20, 'free', NULL);


CREATE TABLE payments(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT NOT NULL,
    payment_date DATE,
    account_number INT,
    first_date_occupied DATE,
    last_date_occupied DATE,
    total_days INT,
    amount_charged DOUBLE(7,2),
    tax_rate DOUBLE(7,2),
    tax_amount DOUBLE(7,2),
    payment_total DOUBLE(7,2),
    notes TEXT
);

INSERT INTO payments VALUES
(1, 1, '2018-12-20', 7438, '2018-12-20', '2018-12-22', 2, 355.50, 30.50, 100.30, 455.80, NULL),
(2, 2, '2018-03-05', 8820, '2018-03-05', '2018-03-15', 10, 999, 20.50, 200.30, 1025.80, NULL),
(3, 3, '2018-02-12', 2233, '2018-02-12', '2018-02-19', 7, 500.50, 10, 50.30, 550.80, NULL);


CREATE TABLE occupancies(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT NOT NULL,
    date_occupied DATE,
    account_number INT,
    room_number INT,
    rate_applied DOUBLE(7,2),
    phone_charge DOUBLE(7,2),
    notes TEXT
);

INSERT INTO occupancies VALUES
(1, 1, '2018-12-20', 7438, 112, 30, 15, NULL),
(2, 2, '2018-03-05', 8820, 202, 20, 10, NULL),
(3, 3, '2018-02-12', 2233, 303, 5, 7, NULL);
