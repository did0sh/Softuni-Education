SELECT m.mountain_range, p.peak_name, p.elevation
FROM mountains AS m
JOIN peaks AS p
ON m.id = 17 AND p.mountain_id = 17
ORDER BY p.elevation DESC;