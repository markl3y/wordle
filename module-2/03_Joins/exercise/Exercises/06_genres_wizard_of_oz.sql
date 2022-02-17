-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECT genre.genre_name FROM movie
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE movie.title = 'The Wizard of Oz';

