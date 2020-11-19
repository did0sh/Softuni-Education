CREATE DATABASE the_nerd_herd;
USE the_nerd_herd;

#01. Table Design ---------------------

CREATE TABLE locations(
	id INT PRIMARY KEY AUTO_INCREMENT,
    latitude FLOAT,
    longitude FLOAT
);

CREATE TABLE credentials(
	id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30),
    password VARCHAR(20)
);

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(25),
    gender CHAR(1),
    age INT,
    location_id INT,
    credential_id INT UNIQUE,
    CONSTRAINT fk_users_locations FOREIGN KEY (location_id) REFERENCES locations(id),
    CONSTRAINT fk_users_credentials FOREIGN KEY (credential_id) REFERENCES credentials(id)
);

CREATE TABLE chats(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(32),
    start_date DATE,
    is_active BIT
);

CREATE TABLE messages(
	id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(200),
    sent_on DATE,
    chat_id INT,
    user_id INT,
    CONSTRAINT fk_messages_chats FOREIGN KEY (chat_id) REFERENCES chats(id),
    CONSTRAINT fk_messages_users FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE users_chats(
	user_id INT,
    chat_id INT,
    CONSTRAINT PRIMARY KEY(user_id, chat_id),
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_chats FOREIGN KEY (chat_id) REFERENCES chats(id)
);

#02. Insert ---------------------

INSERT INTO messages(content, sent_on, chat_id, user_id)
SELECT 
	CONCAT_WS('-', u.age, u.gender, l.latitude, l.longitude) AS content,
    '2016-12-15' AS sent_on,
    (CASE
		WHEN u.gender = 'F' THEN CEIL(SQRT(u.age * 2))
        WHEN u.gender = 'M' THEN POWER((u.age / 18), 3)
    END) AS chat_id,
    u.id
FROM users u
JOIN locations l
ON u.location_id = l.id
WHERE u.id BETWEEN 10 AND 20;

#03. Update ---------------------

UPDATE chats ch
JOIN messages m
ON ch.id = m.chat_id
SET ch.start_date = m.sent_on
WHERE ch.start_date > m.sent_on;

#04. Delete ---------------------

DELETE l FROM locations l
LEFT JOIN users u
ON l.id = u.location_id
WHERE u.id IS NULL;

#Querying	
#05. Age Range ---------------------

SELECT nickname, gender, age FROM users
WHERE age BETWEEN 22 AND 37
ORDER BY id;

#06. Messages ---------------------

SELECT content, sent_on FROM messages
WHERE sent_on > '2014-05-12' AND content LIKE '%just%'
ORDER BY id DESC;

#07. Chats ---------------------

SELECT title, is_active FROM chats
WHERE (is_active = 0 AND CHAR_LENGTH(title) < 5) OR SUBSTR(title, 3, 2) = 'tl'
ORDER BY title DESC;

#08. Chats ---------------------

SELECT c.id, c.title, m.id 
FROM chats c
JOIN messages m
ON c.id = m.chat_id
WHERE m.sent_on < '2012-03-26' AND RIGHT(c.title, 1) = 'x'
ORDER BY c.id, m.id;

#09. Message Count ---------------------

SELECT c.id, COUNT(m.chat_id) AS total_messages
FROM chats c
JOIN messages m
ON c.id = m.chat_id
WHERE m.id < 90
GROUP BY  c.id
ORDER BY total_messages DESC, c.id
LIMIT 5;

#10. Credentials ---------------------

SELECT u.nickname, cr.email, cr.password
FROM users u
JOIN credentials cr
ON u.credential_id = cr.id
WHERE RIGHT(cr.email,5) = 'co.uk'
ORDER BY cr.email;

#11. Locations ---------------------

SELECT u.id, u.nickname, u.age
FROM users u
WHERE u.location_id IS NULL
ORDER BY u.id;

#12. Left Users ---------------------

SELECT DISTINCT m.`id`, m.`chat_id`, m.`user_id`
FROM `chats` AS c
LEFT JOIN `messages` AS m
ON c.`id` = m.`chat_id`
LEFT JOIN `users` AS u
ON m.`user_id` = u.`id`
LEFT JOIN `users_chats` AS us
ON u.`id` = us.`user_id`
WHERE c.`id` = 17 AND u.`id` NOT IN 
			(SELECT uc.`user_id`
			FROM `users` AS u
			LEFT JOIN `users_chats` AS uc
			ON u.`id` = uc.`user_id`
			WHERE uc.`chat_id` = 17)
ORDER BY m.`id` DESC;

#13. Users in Bulgaria ---------------------

SELECT u.nickname, ch.title, l.latitude, l.longitude
FROM users u
JOIN locations l
ON u.location_id = l.id
JOIN users_chats uc
ON uc.user_id = u.id
JOIN chats ch
ON uc.chat_id = ch.id
WHERE l.latitude BETWEEN 41.139999 AND 44.129999 
AND l.longitude BETWEEN 22.209999 AND 28.359999
ORDER BY ch.title;

#14. Last Chat ---------------------

SELECT ch.title, m.content
FROM chats ch
LEFT JOIN messages m
ON m.chat_id = ch.id
WHERE ch.id = 
	(SELECT id 
    FROM chats
    ORDER BY start_date DESC 
    LIMIT 1)
ORDER BY m.sent_on, m.id;

#15. Radians ---------------------

DELIMITER $$
CREATE FUNCTION `udf_get_radians`(`degrees` FLOAT)
RETURNS FLOAT
BEGIN
	DECLARE `radians` FLOAT;
   SET `radians` := (`degrees` * PI()) / 180;
   RETURN `radians`;
END $$

#16. Change Password ---------------------

DELIMITER $$
CREATE PROCEDURE `udp_change_password`(`email` VARCHAR(30), `new_password` VARCHAR(20))
BEGIN
	START TRANSACTION;
	UPDATE `credentials` AS c
	SET c.`password` = `new_password`
	WHERE c.`email` = `email`;
	
	IF ((SELECT COUNT(*)
				FROM `credentials` AS c
				WHERE c.`email` = `email`) <> 1) THEN
		ROLLBACK;
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The email does\'t exist!';
	ELSE
		 COMMIT;
	END IF;
   
END $$

#17. Send Message ---------------------

DELIMITER $$
CREATE PROCEDURE `udp_send_message`(`user_id` INT, `chat_id` INT, `content` VARCHAR(200))
BEGIN
	START TRANSACTION;
	INSERT INTO `messages`(`content`, `sent_on`, `chat_id`, `user_id`)
	VALUES(`content`, '2016-12-15', `chat_id`, `user_id`);
	
	IF ((SELECT COUNT(*)
				FROM `users_chats` AS uc
				WHERE uc.`user_id` = `user_id`
                AND uc.`chat_id` = `chat_id`) < 1) THEN
		ROLLBACK;
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'There is no chat with that user!';
	ELSE
		COMMIT;
	END IF;	
END $$
