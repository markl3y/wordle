-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
SELECT movie.title FROM collection
JOIN movie ON movie.collection_id = collection.collection_id
JOIN person ON person.person_id = movie.director_id
WHERE person.person_name != 'George Lucas' AND collection.collection_name = 'Star Wars Collection';