CREATE FUNCTION ufn_calculate_future_value (initial_sum DOUBLE, interest_rate DOUBLE, number_of_years INT)
RETURNS DOUBLE
BEGIN
	DECLARE future_value DOUBLE;
	SET future_value := initial_sum * (POW((1+interest_rate), number_of_years));
    RETURN future_value;
END;