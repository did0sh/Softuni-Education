SELECT country_name, iso_code
FROM countries
WHERE country_name like '%a%a%a%'
ORDER BY iso_code;