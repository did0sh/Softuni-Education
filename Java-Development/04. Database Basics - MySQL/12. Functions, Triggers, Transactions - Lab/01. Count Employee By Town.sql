CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INT
BEGIN
	DECLARE e_count INT;
    
	SET e_count := (SELECT COUNT(e.employee_id)
    FROM employees e
    JOIN addresses a
    ON e.address_id = a.address_id
    JOIN towns t
    ON a.town_id = t.town_id
    WHERE t.name = town_name);
    
    RETURN e_count;
END