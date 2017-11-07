-- The FROM (table) part determines what is on the LEFT

-- SELECT users.first_name, users.last_name, tweets.tweet, tweets.created_at
-- FROM users
-- JOIN tweets ON users.id = tweets.user_id;
-- Joining one


-- SELECT users.first_name, users.last_name, tweets.tweet, tweets.created_at, faves.id
-- FROM users 
-- JOIN tweets ON users.id = tweets.user_id
-- JOIN faves ON tweets.id = faves.tweet_id;
-- Joining multiple

-- SELECT users.first_name, users.last_name, tweets.tweet
-- FROM users
-- LEFT JOIN tweets ON users.id = tweets.user_id;
-- Joining so that the one user who has no tweet still shows up


-- SELECT users.first_name, users.last_name, GROUP_CONCAT(tweets.tweet, '###') AS tweets
-- FROM users
-- LEFT JOIN tweets ON users.id = tweets.user_id
-- GROUP BY users.id; 
-- GROUP BY squishes multiple entries into one, then you add a function like GROUP_CONCAT or SUM to squish strings together

-- SELECT users.first_name, COUNT(tweets.id)
-- FROM users
-- JOIN tweets on users.id = tweets.user_id
-- GROUP BY users.first_name;
-- The COUNT function counts how many tweets each person had in this instance
