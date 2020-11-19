SELECT t.town_id, t.name, a.address_text
FROM addresses AS a
JOIN towns AS t
ON t.name IN ('San Francisco', 'Sofia', 'Carnation') AND t.town_id = a.town_id
ORDER BY t.town_id, a.address_id;