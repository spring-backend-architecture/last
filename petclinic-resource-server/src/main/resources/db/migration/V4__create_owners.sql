CREATE TABLE owners (
    id         TEXT  CONSTRAINT pk_owner PRIMARY KEY,
    first_name TEXT  NOT NULL CONSTRAINT chk_owner_first_name_length CHECK (length(first_name) BETWEEN 2 AND 50),
    last_name  TEXT  NOT NULL CONSTRAINT chk_owner_last_name_length CHECK (length(last_name) BETWEEN 2 AND 50),
    street     TEXT NOT NULL CONSTRAINT chk_owner_street_length CHECK (length(street) BETWEEN 1 AND 100),
    city       TEXT  NOT NULL CONSTRAINT chk_owner_city_length CHECK (length(city) BETWEEN 1 AND 50),
    telephone  TEXT  NOT NULL CONSTRAINT uq_owner_telephone UNIQUE
);