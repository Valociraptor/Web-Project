SELECT customer.first_name, customer.last_name, customer.email, address.address,  address.address2, address.postal_code
FROM customer
JOIN address ON customer.address_id = address.address_id
WHERE address.city_id = 312;

SELECT film.title, film.description, film.release_year, film.rating, film.special_features, category.name
FROM category
JOIN film_category ON category.category_id = film_category.category_id
JOIN film ON film_category.film_id = film.film_id
WHERE category.name = 'Comedy';

SELECT actor.actor_id, CONCAT( actor.first_name, ' ', actor.last_name) AS actor_name , film.title, film.description, film.release_year
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film on film_actor.film_id = film.film_id
WHERE actor.actor_id = 5;

SELECT customer.first_name, customer.last_name, customer.email, address.address
FROM customer
JOIN address on customer.address_id = address.address_id
WHERE customer.store_id = 1
AND address.city_id IN (1, 42, 312, 459);

SELECT film.title, film.description, film.release_year, film.rating, film.special_features
FROM film
JOIN film_actor on film.film_id = film_actor.film_id
WHERE film.rating = 'G'
 AND film.special_Features LIKE '%behind the scenes%'
 AND film_actor.actor_id = 15;
 
SELECT film.film_id, film.title, actor.actor_id, CONCAT(actor.first_name, ' ', actor.last_name) AS actor_name
FROM actor
JOIN film_actor on actor.actor_id = film_actor.actor_id
JOIN film on film_actor.film_id = film.film_id
WHERE film_actor.film_id = 369;

SELECT film.title, film.description, film.release_year, film.rating, film.special_features, category.name, film.rental_rate
FROM category
JOIN film_category ON category.category_id = film_category.category_id
JOIN film ON film_category.film_id = film.film_id
WHERE category.name = 'Drama'
AND film.rental_rate = 2.99;

SELECT film.title, film.description, film.release_year, film.rating, film.special_features, category.name, actor.first_name, actor.last_name
FROM category
JOIN film_category ON category.category_id = film_category.category_id
JOIN film ON film_category.film_id = film.film_id
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
WHERE category.name = 'Action'
AND CONCAT(actor.first_name, ' ', actor.last_name) = 'Sandra Kilmer';


