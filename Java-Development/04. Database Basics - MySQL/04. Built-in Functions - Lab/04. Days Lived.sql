SELECT CONCAT_WS(' ', first_name, last_name) AS Full_Name,
TIMESTAMPDIFF(DAY, born, died) AS Days_Lived
FROM authors;