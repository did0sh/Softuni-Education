CREATE TABLE categories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    category VARCHAR(50),
    daily_rate DOUBLE(7,2),
    weekly_rate DOUBLE(7,2),
    mothly_rate DOUBLE(7,2),
    weekend_rate DOUBLE(7,2)
);

INSERT INTO categories
VALUES (1, 'High class', 1000, 2000, 3000, 2500), (2, 'Sedan', 150, 200, 134, 540), (3, 'Limousine', 120, 300, 600, 1200);


CREATE TABLE cars(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    plate_number INT NOT NULL,
    make VARCHAR(30),
    model VARCHAR(50),
    car_year DATE,
    category_id INT NOT NULL,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(30),
    available ENUM('Yes', 'No')
);

INSERT INTO cars
VALUES (1, '7449', '7/100', 'Opel Insignia', '2012-10-12', 1, 4, NULL, 'Perfect', 'Yes'), 
(2, '8888', '12/100', 'Mercedez', '2015-10-12', 2, 4, NULL, 'Excellent', 'Yes'), 
(3, '1123', '9/100', 'Nissan', '2015-10-12', 3, 5, NULL, 'Good', 'No');


CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    title VARCHAR(30),
    notes TEXT
);

INSERT INTO employees
VALUES (1, 'First', 'Last', NULL, NULL), 
(2, 'Test2', 'Test', 'Title', 'Notes are here'), 
(3, 'Deyan', 'Petrov', 'Car engineer', '');


CREATE TABLE customers(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    driver_licence_number INT(11) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    address TEXT,
    city VARCHAR(50),
    zip_code INT,
    notes TEXT
);

INSERT INTO customers
VALUES (1, 8827201, 'Kenan The Barbarian', NULL, 'Berlin', 1230, NULL), 
(2, 90912843, 'Ismail Stamatov Goshev', 'Germany, Rhein, street Wald 9', 'Rhein', 9412, 'Please send me the car'),
(3, 7324002, 'Bernard Kruger Jannik', 'England, Goathland, street Merry 13', 'London', 775, 'no');


CREATE TABLE rental_orders(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(50),
	tank_level DOUBLE(5, 2),
	kilometrage_start INT,
	kilometrage_end INT,
	total_kilometrage INT,
	start_date DATE,
	end_date DATE,
	total_days INT,
	rate_applied DOUBLE(7, 2),
	tax_rate DOUBLE(7, 2),
	order_status ENUM('confirmed', 'unconfirmed'),
	notes TEXT
);

INSERT INTO rental_orders
VALUES (1, 5, 82, 2, 'Good', 55, 0, 1000000, 34000, '2009-10-10', NULL, 1200, 340, 500, 'confirmed', 'no notes'), 
(2, 3, 123, 20, 'Explicit', 25.45, 10023, 12354, 2331, '2017-04-20', '2017-05-15', 25, 1500, 22.13, 'unconfirmed', 'no scratchings'),
(3, 3, 29, 34, 'Good', 8.63, 22145, 22541, 396, '2017-05-26', '2017-05-27', 1, 80, 2.65, 'confirmed', NULL);