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

CREATE PROCEDURE usp_get_employees_by_salary_level (level_of_salary VARCHAR(10))
BEGIN
	SELECT em.first_name, em.last_name
    FROM (SELECT e.first_name, e.last_name, ufn_get_salary_level(e.salary) AS salary_level 
    FROM employees e) AS em
    WHERE salary_level = level_of_salary
    ORDER BY em.first_name DESC, em.last_name DESC;
END;