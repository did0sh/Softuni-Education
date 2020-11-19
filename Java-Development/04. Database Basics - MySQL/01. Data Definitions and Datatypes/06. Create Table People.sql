CREATE TABLE people(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB(2048),
    height FLOAT(5, 2),
    weight FLOAT(5, 2),
    gender ENUM('m', 'f') NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography) VALUES 
('DIDO', NULL, 2.20, 45.60, 'm', '1997-02-13', 'tuk e dido'),
('DIDO', NULL, 1.10, 45.60, 'm', '1997-02-14', 'proba'),
('DIDO', NULL, 2.20, 45.60, 'm', '1997-02-15', 'sasho'),
('DIDO', NULL, 2.20, 45.60, 'm', '1997-02-16', 'tuk e dido'),
('DIDO', NULL, 2.20, 45.60, 'm', '1997-02-17', 'tuk e dido');