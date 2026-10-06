package dev.dmitriirussu.petclinic.resource.model;

import java.time.LocalDate;

public record Pet(
        String id,
        String name,
        LocalDate birthDate,
        String type,
        String ownerId
) {}
