-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)
SELECT DISTINCT person.person_name FROM collection
JOIN movie ON movie.collection_id = collection.collection_id
JOIN person ON movie.director_id = person.person_id
WHERE collection.collection_name = 'Harry Potter Collection';
