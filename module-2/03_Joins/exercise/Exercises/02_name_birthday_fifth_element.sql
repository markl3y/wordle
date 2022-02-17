-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person_name, birthday
FROM person
JOIN movie_actor ON movie_actor.actor_id = person.person_id
WHERE movie_id = 
(
	SELECT movie_id
	FROM movie
	WHERE title = 'The Fifth Element'
);

