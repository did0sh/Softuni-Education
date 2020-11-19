CREATE DATABASE buhtig;
USE buhtig;

#01. Table Design --------------------------

CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE repositories(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE repositories_contributors(
	repository_id INT,
    contributor_id INT,
    CONSTRAINT fk_repos FOREIGN KEY(repository_id) REFERENCES repositories(id),
    CONSTRAINT fk_contributors FOREIGN KEY(contributor_id) REFERENCES users(id)
);

CREATE TABLE issues(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    issue_status VARCHAR(6) NOT NULL,
    repository_id INT NOT NULL,
    assignee_id INT NOT NULL,
    CONSTRAINT fk_issues_repos FOREIGN KEY(repository_id) REFERENCES repositories(id),
    CONSTRAINT fk_issues_users FOREIGN KEY(assignee_id) REFERENCES users(id)
);

CREATE TABLE commits(
	id INT PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(255) NOT NULL,
    issue_id INT,
    repository_id INT NOT NULL,
    contributor_id INT NOT NULL,
    CONSTRAINT fk_commits_issues FOREIGN KEY(issue_id) REFERENCES issues(id),
    CONSTRAINT fk_commits_repos FOREIGN KEY(repository_id) REFERENCES repositories(id),
    CONSTRAINT fk_commits_contributers FOREIGN KEY(contributor_id) REFERENCES users(id)
);

CREATE TABLE files(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    size DECIMAL(10,2) NOT NULL,
    parent_id INT,
    commit_id INT NOT NULL,
    CONSTRAINT fk_files FOREIGN KEY(parent_id) REFERENCES files(id),
    CONSTRAINT fk_files_commits FOREIGN KEY(commit_id) REFERENCES commits(id)
);

#02. Data Insertion --------------------------

INSERT INTO issues(title, issue_status, repository_id, assignee_id) 
SELECT 
	CONCAT('Critical Problem With ', f.name, '!'),
	'open' AS issue_status,
    CEIL((f.id * 2) / 3) AS repository_id,
    c.contributor_id AS assignee_id
FROM files f
JOIN commits c
ON c.id = f.commit_id
WHERE f.id BETWEEN 46 AND 50;

#03. Data UPDATE --------------------------

UPDATE `repositories_contributors` AS rc
        JOIN
    (SELECT 
        r.id AS 'repo'
    FROM
        `repositories` AS r
    WHERE
        r.id NOT IN (SELECT 
                repository_id
            FROM
                `repositories_contributors`)
    ORDER BY r.id
    LIMIT 1) AS d 
SET 
    rc.repository_id = d.repo
WHERE
    rc.contributor_id = rc.repository_id;
    
#04. Data Delete -------------------------

DELETE FROM repositories
WHERE repositories.id NOT IN 
(SELECT i.repository_id FROM issues i);

#QUERIES
#05. Users -------------------------

SELECT id, username FROM users
ORDER BY id;

#06. Lucky Numbers -------------------------

SELECT * FROM repositories_contributors
WHERE repository_id = contributor_id
ORDER BY repository_id;

#07. Heavy HTML -------------------------

SELECT id, name, size FROM files
WHERE size > 1000 AND name LIKE '%html%'
ORDER BY size DESC;


#08. Issues and Users -------------------------

SELECT i.id, CONCAT(u.username, ' : ', i.title) FROM issues i
JOIN users u
ON u.id = i.assignee_id
ORDER BY i.id DESC;

#09. Non-Directory Files -------------------------

SELECT fi.id, fi.name, CONCAT(fi.size, 'KB') FROM files fi
LEFT JOIN files f
ON fi.id = f.parent_id
WHERE f.parent_id IS NULL
ORDER BY fi.id;

#10. Active Repositories -------------------------

SELECT r.id, r.name, COUNT(repository_id) AS `issues` FROM issues i
JOIN repositories r
ON i.repository_id = r.id
GROUP BY repository_id
ORDER BY `issues` DESC, r.id
LIMIT 5;

#11. Most Contributed Repository -------------------------

SELECT rc.repository_id, r.name, COUNT(DISTINCT(c.repository_id)) AS commits, COUNT(DISTINCT(rc.contributor_id)) AS count_of_contributors
FROM repositories_contributors rc
LEFT JOIN commits c
ON c.repository_id = rc.repository_id
JOIN repositories r
ON r.id = rc.repository_id
GROUP BY rc.repository_id
ORDER BY count_of_contributors DESC, r.id
LIMIT 1;

#12. fixing My Own Problems -------------------------

SELECT u.id, u.username, SUM(IF(c.contributor_id = u.id, 1, 0))  AS count_of_commits 
FROM users u
LEFT JOIN issues i
ON u.id = i.assignee_id
LEFT JOIN commits c
ON i.id = c.issue_id
GROUP BY u.id
ORDER BY count_of_commits DESC, u.id;

#13. Recursive Commits -------------------------

SELECT SUBSTRING(f.name, 1,  LOCATE('.', f.name) - 1)  AS file, 
COUNT(NULLIF(LOCATE(f.name, c.message),0)) AS recursive_count
FROM files f
JOIN files fi
ON f.parent_id = fi.id
JOIN commits c
WHERE 
	f.id != fi.id
    AND f.parent_id = fi.id
    AND fi.parent_id = f.id
GROUP BY file
ORDER BY file;

#14. Repositories And Commits -------------------------

SELECT r.id, r.name, COUNT(DISTINCT(c.contributor_id)) AS users
FROM commits c
RIGHT JOIN repositories r
ON c.repository_id = r.id
GROUP BY r.name
ORDER BY users DESC, r.id;

#15. Commit -------------------------

DELIMITER $$
CREATE PROCEDURE udp_commit
    (username VARCHAR(30), password VARCHAR(30), message VARCHAR(255), issue_id INT)
BEGIN
    START TRANSACTION;
    
    IF ((SELECT COUNT(u.id) FROM `users` AS u WHERE u.username = username) = 0) THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'No such user!';
        ROLLBACK;
    ELSEIF ((SELECT u.password FROM `users` AS u WHERE u.username = username) <> password) THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Password is incorrect!';
        ROLLBACK;
    ELSEIF ((SELECT COUNT(i.id) FROM `issues` AS i WHERE i.id = issue_id) = 0) THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'The issue does not exist!';
        ROLLBACK;
    ELSE
        INSERT INTO `commits` 
            (`message`, `issue_id`, `repository_id`, `contributor_id`)
        VALUES
            (message,
            issue_id,
            (SELECT i.repository_id FROM `issues` AS i WHERE i.id = issue_id),
            (SELECT u.id FROM `users` AS u WHERE u.username = username));
        UPDATE `issues` AS i 
        SET 
            i.issue_status = 'closed'
        WHERE
            i.id = issue_id;
        COMMIT;
    END IF;
END $$

DELIMITER ;

CALL udp_commit('WhoDenoteBel', 'ajmISQi*', 'Fixed issue: blah', 2);


#16. Filter Extensions -------------------------

DELIMITER $$
CREATE PROCEDURE udp_findbyextension (extension VARCHAR(20))
BEGIN
	SELECT f.id, f.name, CONCAT(f.size, 'KB') AS `user`
    FROM files f
    WHERE f.name LIKE CONCAT('%.', extension)
    ORDER BY f.id;
END;
$$

CALL udp_findbyextension('html');

