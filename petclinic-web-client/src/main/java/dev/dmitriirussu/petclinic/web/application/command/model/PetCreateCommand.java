package dev.dmitriirussu.petclinic.web.application.command.model;

import java.time.LocalDate;

public record PetCreateCommand(String name, LocalDate birthDate, String type, String ownerId) {}
