SELECT deposit_group, MAX(magic_wand_size) AS `longest magic wand`
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest magic wand`, deposit_group;