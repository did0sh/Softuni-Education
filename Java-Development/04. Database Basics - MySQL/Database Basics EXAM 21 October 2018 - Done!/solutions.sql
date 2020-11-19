CREATE DATABASE colonial_journey_management_system_db;

# 0. Table Design -------------------------------------

CREATE TABLE planets(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE spaceports(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    planet_id INT(11),
    CONSTRAINT fk_spaceports_planets FOREIGN KEY(planet_id) REFERENCES planets(id)
);

CREATE TABLE spaceships(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(30) NOT NULL,
    light_speed_rate INT(11) DEFAULT 0
);

CREATE TABLE colonists(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    ucn CHAR(10) NOT NULL UNIQUE,
    birth_date DATE NOT NULL
);

CREATE TABLE journeys(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
   journey_start DATETIME NOT NULL,
   journey_end DATETIME NOT NULL,
   purpose ENUM('Medical', 'Technical', 'Educational', 'Military'),
   destination_spaceport_id INT(11),
   spaceship_id INT(11),
   CONSTRAINT fk_journeys_spaceports FOREIGN KEY(destination_spaceport_id) REFERENCES spaceports(id),
   CONSTRAINT fk_journeys_spaceships FOREIGN KEY(spaceship_id) REFERENCES spaceships(id)
);

CREATE TABLE travel_cards(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    card_number CHAR(10) NOT NULL UNIQUE,
    job_during_journey ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
    colonist_id INT(11),
    journey_id INT(11),
    CONSTRAINT fk_travelcards_colonists FOREIGN KEY(colonist_id) REFERENCES colonists(id),
   CONSTRAINT fk_travelcards_journeys FOREIGN KEY(journey_id) REFERENCES journeys(id)
);

# 4. Extract All Travel Cards -------------------------------------
SELECT card_number, job_during_journey
FROM travel_cards
ORDER BY card_number;

# 5. Extract All Colonists -------------------------------------
SELECT id, CONCAT(first_name, ' ', last_name) AS full_name, ucn
FROM colonists
ORDER BY first_name, last_name, id;

# 6. Extract All Military Journeys -------------------------------------
SELECT id, journey_start, journey_end
FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start;

# 7. Extract All Pilots -------------------------------------
SELECT c.id, CONCAT_WS(' ', c.first_name, c.last_name) AS full_name
FROM travel_cards tc
JOIN colonists c
ON tc.colonist_id = c.id
WHERE tc.job_during_journey = 'Pilot'
ORDER BY c.id;

# 8. Count All Colonists -------------------------------------
SELECT COUNT(tc.colonist_id) AS count
FROM travel_cards tc
JOIN journeys j
ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';

# 9. Extract Fastest Ship -------------------------------------
SELECT s.name, sp.name
FROM journeys j
JOIN spaceships s
ON j.spaceship_id = s.id
JOIN spaceports sp
ON j.destination_spaceport_id = sp.id
ORDER BY s.light_speed_rate DESC
LIMIT 1;

# 10. Extract Spaceships With Pilots Younger Than 30 -------------------------------------
SELECT sp.name, sp.manufacturer 
FROM travel_cards tc
JOIN colonists c
ON tc.colonist_id = c.id
JOIN journeys j
ON j.id = tc.journey_id
JOIN spaceships sp
ON j.spaceship_id = sp.id
WHERE FLOOR(DATEDIFF('2019-01-01', c.birth_date) / 365) < 30
GROUP BY sp.name
ORDER BY sp.name;

# 11. Extract All Educational Mission Plantes And Spaceports -------------------------------------
SELECT p.name, sp.name
FROM journeys j
JOIN spaceports sp
ON j.destination_spaceport_id = sp.id
JOIN planets p
ON p.id = sp.planet_id
WHERE j.purpose = 'Educational'
ORDER BY sp.name DESC;

# 12. Extract All Planets And Their Journey Count -------------------------------------
SELECT p.name, COUNT(j.id) AS journeys_count
FROM journeys j
JOIN spaceports sp
ON j.destination_spaceport_id = sp.id
JOIN planets p
ON p.id = sp.planet_id
GROUP BY p.name
ORDER BY journeys_count DESC, p.name;

# 13. Extract The Shortest Journey -------------------------------------
SELECT j.id, p.name, sp.name, j.purpose
FROM journeys j
JOIN spaceports sp
ON j.destination_spaceport_id = sp.id
JOIN planets p
ON p.id = sp.planet_id
ORDER BY timestampdiff(SECOND, j.journey_start, j.journey_end) ASC
LIMIT 1;

# 14. Extract The Less Popular Job -------------------------------------
SELECT tc.job_during_journey
FROM journeys j
JOIN spaceports sp
ON j.destination_spaceport_id = sp.id
JOIN planets p
ON p.id = sp.planet_id
JOIN travel_cards tc
ON j.id = tc.journey_id
ORDER BY timestampdiff(SECOND, j.journey_start, j.journey_end) DESC
LIMIT 1;

# 15. Get colonists count -------------------------------------

SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER ##
CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30)) 
RETURNS INT
BEGIN
	DECLARE colonists_count INT;
    
    SET colonists_count :=
			(SELECT COUNT(tc.colonist_id)
            FROM journeys j 
            JOIN spaceports sp
		    ON sp.id = j.destination_spaceport_id
            JOIN planets p
            ON p.id = sp.planet_id
            JOIN travel_cards tc
            ON tc.journey_id = j.id
            WHERE p.name = planet_name);
            
	RETURN colonists_count;
END;
##

SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.name = 'Otroyphus';


# 16. Modify Spaceship -------------------------------------

DELIMITER $$
CREATE PROCEDURE 
udp_modify_spaceship_light_speed_rate
(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11)) 

BEGIN
	START TRANSACTION;
    
    IF((SELECT COUNT(sp.id) FROM spaceships sp WHERE sp.name = spaceship_name) = 0)
    THEN SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
    ROLLBACK;
    
    ELSE
    UPDATE spaceships
    SET spaceships.light_speed_rate = spaceships.light_speed_rate + light_speed_rate_increse
    WHERE spaceships.id = 
    (SELECT cq.id FROM 
		(SELECT spa.id FROM spaceships spa WHERE spa.name = spaceship_name) AS cq
    );
    COMMIT;
    
    END IF;
END;
$$

DELIMITER !!
CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT name, light_speed_rate FROM spacheships WHERE name = 'Na Pesho koraba';
!!

DELIMITER @@
CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'USS Templar';
@@

# 01. Data Insertion -------------------------------------
DELIMITER @@
INSERT INTO travel_cards(card_number, job_during_journey, journey_id, colonist_id)
SELECT 
	CASE
		WHEN c.birth_date > '1980-01-01'
        THEN concat(YEAR(c.birth_date), DAY(c.birth_date), LEFT(c.ucn, 4))
        ELSE concat(YEAR(c.birth_date), MONTH(c.birth_date), RIGHT(c.ucn, 4))
	END,
    CASE
		WHEN c.id MOD 2 = 0 THEN 'Pilot'
        WHEN c.id MOD 3 = 0 THEN 'Cook'
        ELSE 'Engineer'
	END,
    LEFT(c.ucn, 1),
    c.id
FROM colonists c
WHERE c.id BETWEEN 96 AND 100;
@@

SELECT * FROM travel_cards;

# 02. Update -------------------------------------

DELIMITER ###
UPDATE journeys j
SET j.purpose = 
	(CASE
		WHEN j.id mod 2 = 0 THEN 'Medical'
        WHEN j.id mod 3 = 0 THEN 'Technical'
        WHEN j.id mod 5 = 0 THEN 'Educational'
        WHEN j.id mod 7 = 0 THEN 'Military'
        ELSE j.purpose
    END);


SELECT * FROM journeys;
###

# 03. Delete -------------------------------------
DELETE FROM colonists
WHERE colonists.id NOT IN 
(
	SELECT colonist_id FROM travel_cards
);