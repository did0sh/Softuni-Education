CREATE PROCEDURE usp_get_towns_starting_with (start_word VARCHAR(50))
BEGIN
	SELECT t.name
    FROM towns t
    WHERE t.name LIKE CONCAT(start_word, '', '%')
    ORDER BY t.name;
END;