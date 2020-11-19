CREATE DATABASE instagraph_db;
USE instagraph_db;

#01. Table Design ---------------------------------

CREATE TABLE pictures(
	id INT PRIMARY KEY AUTO_INCREMENT,
    path VARCHAR(255) NOT NULL,
    size DECIMAL(10,2) NOT NULL
);

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    profile_picture_id INT,
    CONSTRAINT fk_users_pictures FOREIGN KEY (profile_picture_id) REFERENCES pictures(id)
);

CREATE TABLE posts(
	id INT PRIMARY KEY AUTO_INCREMENT,
    caption VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    picture_id INT NOT NULL,
    CONSTRAINT fk_posts_users FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_posts_pics FOREIGN KEY (picture_id) REFERENCES pictures(id)
);

CREATE TABLE comments(
	id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_comments_users FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_comments_posts FOREIGN KEY (post_id) REFERENCES posts(id)
);

CREATE TABLE users_followers(
	user_id INT,
    follower_id INT,
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_followers FOREIGN KEY (follower_id) REFERENCES users(id)
);


#02. Data Insertion ---------------------------------

INSERT INTO comments (content, user_id, post_id)
	SELECT CONCAT('Omg!', u.username, '!This is so cool!') AS content,
    CEIL(p.id * 3 / 2) AS user_id,
    p.id AS post_id
    FROM posts p
    JOIN users u
    ON p.user_id = u.id
    WHERE p.id BETWEEN 1 AND 10;
    
#03. Data Update ---------------------------------

UPDATE users
JOIN 
	(SELECT COUNT(uf.follower_id) AS set_count FROM users_followers uf
    JOIN users u
    ON u.id = uf.user_id
    WHERE uf.user_id = 10
    GROUP BY uf.user_id) AS custom
SET profile_picture_id = custom.set_count
WHERE profile_picture_id IS NULL;


#04. Data Deletion ---------------------------------

DELETE FROM users 
WHERE users.id 
NOT IN (SELECT uf.user_id FROM users_followers uf);


#Querying
#05. Users ---------------------------------

SELECT id, username 
FROM users
ORDER BY id;

#06. Cheaters ---------------------------------

SELECT uf.user_id, u.username 
FROM users_followers uf
JOIN users u
ON u.id = uf.user_id
WHERE uf.user_id = uf.follower_id
ORDER BY u.id;

#07. High Quality Pictures ---------------------------------

SELECT id, path, size 
FROM pictures
WHERE size > 50000 AND (path LIKE '%jpeg%' OR path LIKE '%png%')
ORDER BY size DESC;

#08. Comments and Users ---------------------------------

SELECT c.id, CONCAT(u.username, ' : ', c.content)
FROM comments c
JOIN users u
ON u.id = c.user_id
ORDER BY c.id DESC;

#09. Profile Pictures ---------------------------------

SELECT u.id, u.username, CONCAT(p.size, 'KB') AS size
FROM users u
JOIN pictures p
ON u.profile_picture_id = p.id
JOIN users u2
WHERE u.profile_picture_id = u2.profile_picture_id AND u.id != u2.id
GROUP BY u.id
ORDER BY u.id;

#10. Spam Posts ---------------------------------

SELECT p.id, p.caption, COUNT(c.post_id) AS comments
FROM posts p
LEFT JOIN comments c
ON p.id = c.post_id
GROUP BY p.id
ORDER BY comments DESC, p.id ASC
LIMIT 5;

#11. Most Popular User ---------------------------------

SELECT u.id, 
	   u.username,
       (SELECT COUNT(p.user_id) FROM posts p WHERE p.user_id = u.id) AS posts,
       COUNT(uf.follower_id) AS count_followers
FROM users u
JOIN users_followers uf
ON u.id = uf.user_id
GROUP BY u.id
ORDER BY count_followers DESC
LIMIT 1;

#12. Commenting Myself ---------------------------------

SELECT u.id, 
	   u.username,
       SUM(IF(c.user_id = u.id, 1, 0)) AS my_comments
FROM users u
LEFT JOIN posts p
ON u.id = p.user_id
LEFT JOIN comments c
ON p.id = c.post_id
GROUP BY u.id
ORDER BY my_comments DESC, u.id ASC;

#13. User Top Posts ---------------------------------

SELECT u.id, u.username, cq1.caption FROM
users u
JOIN
(
	SELECT 	cq.id, cq.user_id, cq.caption, max(cq.count_captions)
    FROM
    (SELECT p.id, p.user_id, p.caption, COUNT(c.id) AS count_captions 
		FROM posts p
        LEFT JOIN comments c
        ON c.post_id = p.id
        GROUP BY p.id
        ORDER BY count_captions DESC, p.id
	) cq
    GROUP BY cq.user_id
	ORDER BY cq.user_id
) cq1
ON u.id = cq1.user_id;


#14. Posts and Commentators ---------------------------------

SELECT p.id, p.caption, COUNT(DISTINCT(c.user_id)) AS users
FROM posts p
LEFT JOIN comments c
ON p.id = c.post_id
GROUP BY p.caption
ORDER BY users DESC, p.id ASC;

#15. Post ---------------------------------

DELIMITER $$
CREATE PROCEDURE udp_post(
	username VARCHAR(30),
	password VARCHAR(30), 
	caption VARCHAR(255), 
	path VARCHAR(255))
BEGIN

	DECLARE user_id INT(11);
    DECLARE picture_id INT(11);

	IF ((SELECT u.password 
        FROM users AS u
        WHERE u.username = username) <> password)
    THEN 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Password is incorrect!';
	END IF;
    
    IF ((SELECT COUNT(p.path) 
        FROM pictures AS p
        WHERE p.path = path) = 0)
    THEN 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The picture does not exist!';
    END IF;
    
    SET user_id := (
		SELECT id
		FROM users AS u
		WHERE u.username = username 
	);
    
    SET picture_id := (
		SELECT p.id
		FROM pictures AS p
		WHERE p.path LIKE path 
	);
    
    INSERT INTO posts (caption, user_id, picture_id)
    VALUES (caption, user_id, picture_id);
    
END $$

CALL udp_post (
		'UnderSinduxrein',
        '4l8nYGTKMW',
        '#new #procedure',
        'src/folders/resources/images/story/reformatted/img/hRI3TW31rC.img'
		);
        
CALL udp_post (
		'UnderSinduxrein',
        '4l8nYGTKMW',
        '#new #procedure',
        'src/.img'
		);
        
CALL udp_post (
		'UnderSinduxrein',
        '****',
        '#new #procedure',
        'src/folders/resources/images/story/reformatted/img/hRI3TW31rC.img'
		);
        
        
        
#16. Filter ---------------------------------

DELIMITER $$
CREATE PROCEDURE udp_filter (hashtag VARCHAR(30))
BEGIN
	SELECT p.id, p.caption, u.username
    FROM posts p
    JOIN users u
    ON p.user_id = u.id
    WHERE p.caption LIKE CONCAT('%#', hashtag, '%')
    ORDER BY p.id;
END;
$$

CALL udp_filter('cool');