-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT DISTINCT person.person_name, person.birthday FROM movie
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON person.person_id = movie_actor.actor_id
WHERE (person.birthday BETWEEN '19500101' AND '19591231') AND (movie.release_date BETWEEN '19850101' AND '19851231');
