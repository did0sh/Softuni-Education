ALTER TABLE wizzard_deposits
ADD COLUMN age_sorted VARCHAR(20);

UPDATE wizzard_deposits
SET age_sorted = '[0-10]'
WHERE age <= 10;

UPDATE wizzard_deposits
SET age_sorted = '[11-20]'
WHERE age > 10 AND age <= 20;

UPDATE wizzard_deposits
SET age_sorted = '[21-30]'
WHERE age > 20 AND age <= 30;

UPDATE wizzard_deposits
SET age_sorted = '[31-40]'
WHERE age > 30 AND age <= 40;

UPDATE wizzard_deposits
SET age_sorted = '[41-50]'
WHERE age > 40 AND age <= 50;

UPDATE wizzard_deposits
SET age_sorted = '[51-60]'
WHERE age > 50 AND age <= 60;

UPDATE wizzard_deposits
SET age_sorted = '[61+]'
WHERE age > 60;

SELECT age_sorted, COUNT(age_sorted) 
FROM wizzard_deposits
GROUP BY age_sorted
ORDER BY age_sorted;