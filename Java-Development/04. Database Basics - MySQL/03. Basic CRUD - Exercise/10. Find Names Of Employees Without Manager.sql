SELECT first_name, last_name FROM employees
WHERE manager_id IS NULL
ORDER BY employee_id;