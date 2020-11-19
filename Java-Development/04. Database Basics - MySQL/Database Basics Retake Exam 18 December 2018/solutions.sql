CREATE DATABASE ruk_database;

# 01. Table Design -----------------------------------
CREATE TABLE branches(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    started_on DATE NOT NULL,
    branch_id INT(11) NOT NULL,
    CONSTRAINT fk_employees_branches FOREIGN KEY(branch_id) REFERENCES branches(id)
);

CREATE TABLE clients(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(50) NOT NULL,
    age INT(11) NOT NULL
);

CREATE TABLE employees_clients(
	employee_id INT(11),
    client_id INT(11),
     CONSTRAINT fk_employees FOREIGN KEY(employee_id) REFERENCES employees(id),
     CONSTRAINT fk_clients FOREIGN KEY(client_id) REFERENCES clients(id)
);

CREATE TABLE bank_accounts(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(10) NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    client_id INT(11) NOT NULL UNIQUE,
    CONSTRAINT fk_accounts_clients FOREIGN KEY(client_id) REFERENCES clients(id)
);

CREATE TABLE cards(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    card_number VARCHAR(19) NOT NULL,
    card_status VARCHAR(7) NOT NULL,
    bank_account_id INT(11) NOT NULL,
    CONSTRAINT fk_cards_accounts FOREIGN KEY(bank_account_id) REFERENCES bank_accounts(id)
);

# 05. Clients -----------------------------------
SELECT id, full_name
FROM clients
ORDER BY id;

# 06.  Lucky Numbers -----------------------------------
SELECT employee_id, client_id
FROM employees_clients
WHERE employee_id = client_id
ORDER BY client_id;

# 07.  Newbies -----------------------------------
SELECT id, CONCAT(first_name, ' ', last_name) AS full_name, salary, started_on
FROM employees
WHERE salary >= 100000 AND started_on >= '2018-01-01'
ORDER BY salary DESC;

# 08. Cards Against Humanity -----------------------------------
SELECT c.id, CONCAT(c.card_number, ' : ', cl.full_name) AS card_token
FROM cards c
JOIN bank_accounts ba
ON c.bank_account_id = ba.id
JOIN clients cl
ON cl.id = ba.client_id
ORDER BY c.id DESC;

# 09.  Disabled Accounts -----------------------------------
SELECT cq.account_number, cq.balance, cq.full_name FROM
(SELECT ba.account_number, ba.balance, cl.full_name, COUNT(ba.account_number) AS count_without, 
	(
		SELECT COUNT(b.account_number) count_cards FROM bank_accounts b JOIN cards ca ON ca.bank_account_id = b.id
		WHERE ca.card_status IN ('Frozen', 'Deleted') AND b.account_number = ba.account_number
		GROUP BY b.account_number 
	) count_with
FROM bank_accounts ba
JOIN cards c
ON ba.id = c.bank_account_id
JOIN clients cl
ON cl.id = ba.client_id
GROUP BY ba.account_number
HAVING count_without = count_with
ORDER BY ba.id DESC
) `cq`;


# 10. Top 5 Employees -----------------------------------
SELECT CONCAT(emp.first_name, ' ', emp.last_name) AS name, emp.started_on, COUNT(ec.client_id) AS count_of_clients
FROM employees emp
JOIN employees_clients ec
ON emp.id = ec.employee_id
GROUP BY emp.id
ORDER BY count_of_clients DESC, emp.id ASC
LIMIT 5;

# 11. Family Guy -----------------------------------
SELECT cl.id, cl.full_name, COUNT(c.id) cards
FROM cards c
JOIN bank_accounts ba 
ON c.bank_account_id = ba.id
JOIN clients cl
ON cl.id = ba.client_id
GROUP BY cl.id
ORDER BY cards DESC, cl.id ASC
LIMIT 1;

# 12. Adashes -----------------------------------
SELECT SUBSTRING_INDEX(cl.full_name, ' ', 1) AS `client_name`, emp.first_name
FROM employees_clients ec
JOIN employees emp
ON emp.id = ec.employee_id
JOIN clients cl
ON cl.id = ec.client_id
WHERE SUBSTRING_INDEX(cl.full_name, ' ', 1) = emp.first_name
ORDER BY cl.id;

# 13. Branching Clients -----------------------------------
SELECT b.name, COUNT(ec.client_id) clients
from branches b
JOIN employees emp
ON emp.branch_id = b.id
JOIN employees_clients ec
ON ec.employee_id = emp.id
GROUP BY b.id
ORDER BY clients DESC, b.id ASC;

# 02. Insert Data -----------------------------------
INSERT INTO cards(card_number, card_status, bank_account_id)
SELECT CONCAT(REVERSE(SUBSTRING_INDEX(cl.full_name, ' ', 1)), ' ', REVERSE(SUBSTRING_INDEX(cl.full_name, ' ', -1))),
'Active',
ba.id
FROM clients cl
JOIN bank_accounts ba
ON cl.id = ba.client_id
WHERE cl.id BETWEEN 191 AND 200;

# 03. Delete -----------------------------------
DELETE FROM employees
WHERE employees.id NOT IN
(
	SELECT employee_id
    FROM employees_clients
);

# 14. Extract Client Info -----------------------------------
DELIMITER $$
CREATE PROCEDURE 
udp_clientinfo (full_name VARCHAR(50)) 

BEGIN
   START TRANSACTION;
   
	SELECT cl.full_name, cl.age, ba.account_number, CONCAT('$',ba.balance) AS balance
    FROM bank_accounts ba
    JOIN clients cl
    ON ba.client_id = cl.id
    WHERE cl.full_name = full_name;
    
    COMMIT;
END;
$$

CALL udp_clientinfo('Hunter Wesgate');


# 04. Update -----------------------------------
DELIMITER %%
UPDATE employees_clients
JOIN 
	(SELECT COUNT(ec.client_id) AS set_count FROM employees_clients ec
    JOIN employees e
    ON e.id = ec.employee_id
    GROUP BY ec.employee_id
    ORDER BY set_count ASC
    LIMIT 1) AS custom
SET employees_clients.client_id = custom.set_count
WHERE employees_clients.client_id = employees_clients.employee_id;
%%