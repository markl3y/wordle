-- 20. The name, population, area, and population density (name the column 'population_density') of states, territories, and districts with more than 100 people per square kilometer (12 rows)
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
SELECT state_name, population, area, cast(cast(population as decimal(10,2))/cast(area as decimal(10,2)) as decimal(10,2)) AS population_density 
FROM state
WHERE cast(population as decimal(10,2))/cast(area as decimal(10,2)) > 100