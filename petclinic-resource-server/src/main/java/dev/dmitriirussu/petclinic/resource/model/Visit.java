package dev.dmitriirussu.petclinic.resource.model;

import java.time.LocalDate;

public record Visit(
        String id,
        LocalDate visitDate,
        String description,
        String petId
) {}
