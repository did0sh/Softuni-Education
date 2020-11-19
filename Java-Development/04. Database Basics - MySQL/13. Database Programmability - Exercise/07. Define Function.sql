CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
BEGIN
	DECLARE `length` INT DEFAULT CHAR_LENGTH(word);
    DECLARE `index` INT DEFAULT 1;
    WHILE `index` <= `length`
    DO
		IF LOCATE(SUBSTRING(word, `index`, 1), set_of_letters) < 1 THEN
        RETURN 0;
        END IF;
        SET `index` = `index` + 1;
        END WHILE;
        RETURN 1;
END;