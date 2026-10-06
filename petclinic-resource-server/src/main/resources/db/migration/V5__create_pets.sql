CREATE TABLE pets (
    id         TEXT CONSTRAINT pk_pet PRIMARY KEY,
    name       TEXT NOT NULL CONSTRAINT chk_pet_name_length CHECK (length(name) BETWEEN 1 AND 30),
    birth_date DATE        NOT NULL CONSTRAINT chk_pet_birth_date_not_future CHECK (birth_date <= CURRENT_DATE),
    type       TEXT NOT NULL CONSTRAINT fk_pet_type REFERENCES pet_types(name),
    owner_id   TEXT NOT NULL CONSTRAINT fk_pet_owner REFERENCES owners(id) ON DELETE CASCADE,
    CONSTRAINT uq_pet_identity UNIQUE (owner_id, name, birth_date, type)
);
