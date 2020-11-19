CREATE TABLE directors(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    director_name VARCHAR(30) NOT NULL,
    notes TEXT
);

INSERT INTO directors (id, director_name, notes) 
VALUES (1, 'PESHO', 'note'), (2, 'SASHO', 'note'), (3, 'dido', 'note'), (4, 'Isma', 'note'), (5, 'unknown', NULL);


CREATE TABLE genres(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    genre_name VARCHAR(30) NOT NULL,
    notes TEXT
);

INSERT INTO genres (id, genre_name, notes) 
VALUES (1, 'Thriller', 'note'), (2, 'Fantasy', 'note'), (3, 'Love story', 'note'), (4, 'True story', 'note'), (5, 'Scary movie', NULL);

CREATE TABLE categories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    category_name VARCHAR(30) NOT NULL,
    notes TEXT
);

INSERT INTO categories (id, category_name, notes) 
VALUES (1, 'Test1', 'note'), (2, 'Test2', 'note'), (3, 'Test3', 'note'), (4, 'Test4', 'note'), (5, 'Test5', NULL);

CREATE TABLE movies(
	id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(50) NOT NULL,
    director_id INT NOT NULL,
    copyright_year DATE,
    length VARCHAR(20) NOT NULL,
    genre_id INT NOT NULL,
    category_id INT NOT NULL,
    rating VARCHAR(50),
    notes TEXT
);

INSERT INTO movies (id, title, director_id, copyright_year, length, genre_id, category_id, rating, notes) 
VALUES (1, 'SQL rules', 1, '2002-12-12', '120 minutes', 5, 5, 'super', 'no notes'), 
(2, 'SQL rules again', 2, '2002-12-12', '120 minutes', 4, 4, 'brilliant', 'no notes'),
(3, 'The homework', 3, '2002-12-12', '140 minutes', 3, 3, 'no comment', 'no notes'),
(4, 'Boring already', 4, NULL, '2 minutes', 2, 2, 'super', 'no notes'),
(5, 'Last one', 5, '2002-12-12', '3 hours', 1, 1, 'nice', 'no notes');
