SELECT 
    e.`first_name`, e.`last_name`, e.`department_id`
FROM
    `employees` AS e,
    (SELECT 
        e.`department_id`, AVG(e.`salary`) AS `avg_salary`
    FROM
        `employees` AS e
    GROUP BY `department_id`) AS `avg_sallary_by_departments`
WHERE
    e.`department_id` = `avg_sallary_by_departments`.`department_id`
        AND e.`salary` > `avg_sallary_by_departments`.`avg_salary`
ORDER BY e.`department_id`
LIMIT 10;