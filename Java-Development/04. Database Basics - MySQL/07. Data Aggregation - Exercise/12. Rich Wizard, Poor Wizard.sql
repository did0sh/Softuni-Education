CREATE VIEW richW_poorW AS
SELECT 
wd1.first_name AS host_wizard,
wd1.deposit_amount AS host_wizard_deposit,
wd2.first_name AS guest_wizard,
wd2.deposit_amount AS guest_wizard_deposit
FROM 
wizzard_deposits AS wd1,
wizzard_deposits AS wd2
WHERE wd1.id + 1 = wd2.id;

SELECT SUM(host_wizard_deposit - guest_wizard_deposit) AS sum_difference
FROM richW_poorW;