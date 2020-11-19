CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(19,4))
BEGIN
	DECLARE future_value DECIMAL(19,4);
    
	DECLARE balance DECIMAL(19,4);
    
	SET balance := (SELECT a.balance FROM accounts a WHERE a.id = account_id);
    
	SET future_value := balance * (POW((1+interest_rate), 5));
    
    SELECT a.id, ah.first_name, ah.last_name, a.balance, future_value
    FROM accounts a
    INNER JOIN account_holders ah
    ON a.account_holder_id = ah.id
    AND a.id = account_id;
END;