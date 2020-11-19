CREATE TABLE country_currencies
AS SELECT country_name, country_code, currency_code 
FROM countries;

ALTER TABLE country_currencies
MODIFY COLUMN currency_code VARCHAR(20);

UPDATE country_currencies
SET currency_code = 'Not Euro'
WHERE currency_code != 'EUR';

UPDATE country_currencies
SET currency_code = 'Euro'
WHERE currency_code = 'EUR';

SELECT * FROM country_currencies
ORDER BY country_name;