CREATE PROCEDURE usp_get_employees_salary_above(amount_salary DECIMAL(19,4))
BEGIN
	SELECT e.first_name, e.last_name 
    FROM employees e
    WHERE e.salary >= amount_salary
    ORDER BY e.first_name, e.last_name, e.employee_id;
END;