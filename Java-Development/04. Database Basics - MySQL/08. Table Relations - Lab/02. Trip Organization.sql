SELECT 
c.id AS driver_id,
v.vehicle_type,  
CONCAT_WS(' ', c.first_name, c.last_name) AS driver_name
FROM campers c
JOIN vehicles v
ON c.id = v.driver_id;