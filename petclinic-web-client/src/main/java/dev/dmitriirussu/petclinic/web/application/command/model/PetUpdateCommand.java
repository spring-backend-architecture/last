package dev.dmitriirussu.petclinic.web.application.command.model;

import java.time.LocalDate;

public record PetUpdateCommand(String petId, String name, LocalDate birthDate, String type, String ownerId) {}
