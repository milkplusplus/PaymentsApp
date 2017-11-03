DELIMITER $$
DROP PROCEDURE IF EXISTS `fill_db1`$$
CREATE PROCEDURE fill_db1()
BEGIN
	DECLARE NUMBER_OF_PEOPLE INT DEFAULT 4;
	DECLARE i INT;
	DECLARE j INT;
	DECLARE k INT;
	DECLARE cards_counter INT;
	DECLARE tr_counter INT;
	DECLARE bug_fixer INT; 		-- FIX ME
	DECLARE bug_fixer1 INT;

	DECLARE mylog VARCHAR(6);
	DECLARE mypass VARCHAR(6);

	DECLARE first_n VARCHAR(10);
	DECLARE last_n VARCHAR(12);
	DECLARE sur_n VARCHAR(14);

	DECLARE my_balance INT;

	DECLARE adm VARCHAR(12) DEFAULT 'admin';
	DECLARE us VARCHAR(12) DEFAULT 'user'; 

	DECLARE role VARCHAR(12);

	SET i = 1;
	SET bug_fixer = i;
	SET bug_fixer1 = i;
	SET cards_counter = 0;
	SET tr_counter = 0;
	WHILE i <= NUMBER_OF_PEOPLE DO

		SET mylog = SUBSTRING(MD5(RAND()) FROM 1 FOR 6);
		SET mypass = SUBSTRING(MD5(RAND()) FROM 1 FOR 6);

		IF (i % 2) > 0 THEN SET role = adm;
		ELSE SET role = us;
		END IF;

		INSERT INTO users
			(id, is_admin, login, password)	
		VALUES
			( i, role, mylog, mypass );


		SET first_n = SUBSTRING(MD5(RAND()) FROM 1 FOR 10);
		SET last_n = SUBSTRING(MD5(RAND()) FROM 1 FOR 12);
		SET sur_n = SUBSTRING(MD5(RAND()) FROM 1 FOR 14);
		INSERT INTO clients
			(id, first_name, last_name, surname, user_id)
		VALUES
			(i, first_n, last_n, sur_n, i);
		
		
		SET j = 3 + FLOOR(RAND()*5);
		SET k = 2 + FLOOR(RAND()*5);

		WHILE cards_counter < j DO
			SET my_balance = FLOOR(RAND()*100);
			INSERT INTO bank_accounts
				(id, balance, is_blocked)
			VALUES
				(bug_fixer+cards_counter, my_balance, FLOOR(RAND()*2));
			

			INSERT INTO cards
				(id, card_number, account_id, client_id)
			VALUES
				(bug_fixer+cards_counter, CONCAT(CONCAT(i,'000'), SUBSTRING(MD5(RAND()) FROM 1 FOR 12)), 
				bug_fixer+cards_counter, i);


			WHILE tr_counter < k DO
			
				INSERT INTO transactions
					(id, tr_date, tr_sum, tr_type, card_id, client_id)
				VALUES
					(bug_fixer1+tr_counter,DATE_ADD('2017-06-07', INTERVAL FLOOR(RAND()*3) DAY), my_balance - FLOOR(RAND()*5),
					 FLOOR(RAND()*2), bug_fixer+cards_counter, i);

				SET tr_counter = tr_counter + 1;

			END WHILE;

			SET tr_counter = 0;
			SET bug_fixer1 = bug_fixer1 + k;

			SET cards_counter = cards_counter + 1;			

		END WHILE;	

		
		SET cards_counter = 0;
		SET bug_fixer = bug_fixer + j;

		SET i = i + 1;

	END WHILE;
END$$
DELIMITER ;

CALL fill_db1();