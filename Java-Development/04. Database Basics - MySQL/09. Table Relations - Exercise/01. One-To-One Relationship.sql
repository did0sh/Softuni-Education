CREATE SCHEMA one_to_one_relationship;

CREATE TABLE passports(
	passport_id INT PRIMARY KEY AUTO_INCREMENT,
    passport_number VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE persons(
	person_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    salary DECIMAL(15,2),
    passport_id INT UNIQUE,
    CONSTRAINT fk_passport_persons FOREIGN KEY (passport_id) REFERENCES passports(passport_id)
);

INSERT INTO passports(passport_id, passport_number) 
VALUES(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');


INSERT INTO persons(person_id, first_name, salary, passport_id) 
VALUES(1, 'Roberto', 43300, 102),
(2, 'Tom', 56100, 103),
(3, 'Yana', 60200, 101);