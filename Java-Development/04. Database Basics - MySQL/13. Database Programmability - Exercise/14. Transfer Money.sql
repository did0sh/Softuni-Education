CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4)) 
BEGIN
	START TRANSACTION;
		UPDATE accounts SET balance = balance - amount
			WHERE id = from_account_id;
			UPDATE accounts SET balance = balance + amount
			WHERE id = to_account_id;
			
		IF((SELECT COUNT(*) FROM accounts
		      WHERE id = from_account_id) <> 1)
		   THEN ROLLBACK;
		ELSEIF(amount > (SELECT balance FROM accounts WHERE id = from_account_id))
			THEN ROLLBACK;
		ELSEIF(amount <= 0)
			THEN ROLLBACK;
		ELSEIF((SELECT balance FROM accounts WHERE id = from_account_id) <= 0)
			THEN ROLLBACK;	
		ELSEIF((SELECT COUNT(*) FROM accounts
		      WHERE id = to_account_id) <> 1)
		   THEN ROLLBACK;
		ELSEIF(amount <= 0)
			THEN ROLLBACK;
		ELSEIF(from_account_id = to_account_id)
			THEN ROLLBACK;
		ELSE 
			COMMIT;
		END IF;

END;