CREATE SCHEMA school;

CREATE TABLE students(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE exams(
	exam_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE students_exams(
	student_id INT,
    exam_id INT,
    CONSTRAINT pk_students_exam PRIMARY KEY (student_id, exam_id),
    CONSTRAINT fk_exam FOREIGN KEY (exam_id) REFERENCES exams(exam_id),
    CONSTRAINT fk_students FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO students(student_id, name) 
VALUES(1, 'Mila'),
(2, 'Toni'),
(3, 'Ron');

INSERT INTO exams(exam_id, name) 
VALUES(101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

INSERT INTO students_exams(student_id, exam_id) 
VALUES(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);