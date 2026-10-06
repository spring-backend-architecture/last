CREATE TABLE visits (
    id          TEXT  CONSTRAINT pk_visit PRIMARY KEY,
    visit_date  DATE         NOT NULL,
    description TEXT NOT NULL CONSTRAINT chk_visit_description_length CHECK (length(description) BETWEEN 1 AND 255),
    pet_id      TEXT  NOT NULL CONSTRAINT fk_visit_pet REFERENCES pets(id) ON DELETE CASCADE,
    CONSTRAINT uq_visit_pet_date UNIQUE (pet_id, visit_date)
);