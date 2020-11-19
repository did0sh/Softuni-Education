CREATE FUNCTION ufn_get_salary_level (salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level VARCHAR(10);
    SET salary_level := 
    (CASE 
		WHEN salary < 30000 THEN 'Low'
		WHEN salary >= 30000 AND salary <= 50000 THEN 'Average'
        WHEN salary > 50000 THEN 'High'
	END
    );
    RETURN salary_level;
END;