
CREATE TABLE IF NOT EXISTS countries (
    id IDENTITY PRIMARY KEY,
    country_full VARCHAR(100) NOT NULL,
    country_short VARCHAR(10) NOT NULL
);


CREATE TABLE IF NOT EXISTS regions (
    id IDENTITY PRIMARY KEY,
    country_id BIGINT NOT NULL,
    region VARCHAR(100) NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(id)
);


CREATE TABLE IF NOT EXISTS cities (
    id IDENTITY PRIMARY KEY,
    region_id BIGINT NOT NULL,
    city VARCHAR(100) NOT NULL,
    FOREIGN KEY (region_id) REFERENCES regions(id)
);


CREATE TABLE IF NOT EXISTS addresses (
    id IDENTITY PRIMARY KEY,
    person VARCHAR(100) NOT NULL,
    city_id BIGINT NOT NULL,
    street VARCHAR(200) NOT NULL,
    building VARCHAR(20) NOT NULL,
    office VARCHAR(20),
    FOREIGN KEY (city_id) REFERENCES cities(id)
);