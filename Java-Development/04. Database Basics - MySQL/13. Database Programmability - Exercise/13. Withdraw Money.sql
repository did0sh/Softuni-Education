CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
START TRANSACTION;
  IF((SELECT a.balance FROM accounts AS a WHERE a.id = account_id) >= money_amount) THEN
      IF (money_amount > 0) THEN
         UPDATE accounts 
         SET balance = balance - money_amount
         WHERE id = account_id;
         COMMIT;
      ELSE 
	     ROLLBACK;
      END IF;
  ELSE
     ROLLBACK;
  END IF;
END
$$