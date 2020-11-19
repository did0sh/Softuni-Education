CREATE TABLE game_duration AS
SELECT name, EXTRACT(HOUR FROM start) AS hours, duration
FROM games;

ALTER TABLE game_duration
ADD COLUMN part_of_the_day VARCHAR(30);

ALTER TABLE game_duration
ADD COLUMN duration_with_words VARCHAR(30);

UPDATE game_duration
SET part_of_the_day = 'Morning'
WHERE hours >= 0 AND hours < 12;

UPDATE game_duration
SET part_of_the_day = 'Afternoon'
WHERE hours >= 12 AND hours < 18;

UPDATE game_duration
SET part_of_the_day = 'Evening'
WHERE hours >= 18 AND hours < 24;

UPDATE game_duration
SET duration_with_words = 'Extra Short'
WHERE duration <= 3;

UPDATE game_duration
SET duration_with_words = 'Short'
WHERE duration > 3 AND duration <= 6;

UPDATE game_duration
SET duration_with_words = 'Long'
WHERE duration > 6 AND duration <= 10;

UPDATE game_duration
SET duration_with_words = 'Extra Long'
WHERE duration > 10 OR duration IS NULL;

SELECT name, part_of_the_day AS `Part of the Day`, duration_with_words AS `Duration` 
FROM game_duration;