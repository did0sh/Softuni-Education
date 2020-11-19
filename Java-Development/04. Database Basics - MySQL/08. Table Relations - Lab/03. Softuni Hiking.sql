SELECT r.starting_point, r.end_point, c.id AS leader_id, CONCAT_WS(' ', c.first_name, c.last_name) AS leader_name
FROM routes r
JOIN campers c
ON r.leader_id = c.id;