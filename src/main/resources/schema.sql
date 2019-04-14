CREATE TABLE scores (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    score INTEGER NOT NULL CHECK (score > 0),
    country_code CHAR(2) NOT NULL,
    timestamp TIMESTAMP NOT NULL
);