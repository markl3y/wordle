-- 20. The state abbreviation, and population of the largest city (name column 'city_population') of all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)
SELECT state_abbreviation, (SELECT MAX(population) FROM city WHERE state_abbreviation = state.state_abbreviation) AS city_population
FROM state
ORDER BY city_population DESC;