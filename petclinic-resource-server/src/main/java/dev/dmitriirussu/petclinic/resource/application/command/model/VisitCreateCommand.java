package dev.dmitriirussu.petclinic.resource.application.command.model;

import java.time.LocalDate;

public record VisitCreateCommand(
        LocalDate visitDate,
        String description,
        String petId,
        String ownerId
) {}
