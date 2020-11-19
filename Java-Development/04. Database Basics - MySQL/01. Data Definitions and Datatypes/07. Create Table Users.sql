CREATE TABLE users(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB(900),
    last_login_time DATETIME,
    is_deleted BIT
);

INSERT INTO users (username, password, profile_picture, last_login_time, is_deleted) VALUES 
('test1', '123', NULL, NOW(), 1),
('test1234', 'asdf', NULL, NOW(), 0),
('dido', 'qwer', NULL, NOW(), 0),
('kevin', '12', NULL, NOW(), 1),
('simon', '0000', NULL, NOW(), 1);