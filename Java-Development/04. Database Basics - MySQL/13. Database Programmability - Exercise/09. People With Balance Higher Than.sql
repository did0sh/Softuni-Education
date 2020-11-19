CREATE PROCEDURE usp_get_holders_with_balance_higher_than(num DECIMAL(19,4))
BEGIN
	SELECT a.first_name, a.last_name
    FROM account_holders a
    JOIN accounts acc 
    ON a.id = acc.account_holder_id
    GROUP BY acc.account_holder_id
    HAVING SUM(acc.balance) > num
    ORDER BY acc.id, a.first_name, a.last_name;
END;