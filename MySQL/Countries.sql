SELECT  countries.name, languages.language, languages.percentage
FROM countries
JOIN languages ON countries.id = country_id
WHERE language = 'Slovene'
ORDER BY percentage DESC;

SELECT countries.name, COUNT(cities.id)
FROM countries 
JOIN cities ON countries.id = country_id
GROUP BY countries.name
ORDER BY COUNT(cities.id) DESC;

SELECT countries.name, cities.name, cities.population
FROM countries 
JOIN cities ON countries.id = country_id
WHERE countries.name = 'Mexico' && cities.population > 500000
ORDER BY cities.population DESC;

SELECT  countries.name, languages.language, languages.percentage
FROM countries
JOIN languages ON countries.id = country_id
WHERE languages.percentage > 89
ORDER BY languages.percentage DESC;

SELECT * FROM countries
WHERE population > 100000 && surface_area < 501;

SELECT countries.name, countries.government_form, countries.life_expectancy, countries.capital, cities.name
FROM cities
JOIN countries on cities.id = capital
WHERE countries.government_form = 'Constitutional Monarchy' && countries.life_expectancy > 75 && capital > 200;

SELECT countries.name, cities.name, cities.population, cities.district
FROM countries 
JOIN cities ON countries.id = country_id
WHERE countries.name = 'Argentina' && cities.district = 'Buenos Aires' && cities.population > 500000;

SELECT countries.region, COUNT(countries.name)
FROM countries
GROUP BY region;