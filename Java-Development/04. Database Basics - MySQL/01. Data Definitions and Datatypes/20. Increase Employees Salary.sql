UPDATE employees
SET employees.salary = employees.salary + (0.1*employees.salary);

SELECT salary FROM employees;