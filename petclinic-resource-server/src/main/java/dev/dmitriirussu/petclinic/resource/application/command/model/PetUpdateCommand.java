package dev.dmitriirussu.petclinic.resource.application.command.model;

import java.time.LocalDate;

public record PetUpdateCommand(
        String id,
        String name,
        LocalDate birthDate,
        String type,
        String ownerId
) {}

