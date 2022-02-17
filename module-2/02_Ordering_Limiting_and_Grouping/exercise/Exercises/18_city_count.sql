-- 18. The count of the number of cities (name column 'num_cities') and the state abbreviation for each state and territory (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)
SELECT (SELECT COUNT(*) FROM city WHERE state_abbreviation = state.state_abbreviation) AS num_cities, state_abbreviation 
FROM state
WHERE state_abbreviation != 'DC'
ORDER BY state_abbreviation;