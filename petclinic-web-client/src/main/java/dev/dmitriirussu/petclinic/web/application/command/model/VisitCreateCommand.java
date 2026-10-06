package dev.dmitriirussu.petclinic.web.application.command.model;

import java.time.LocalDate;

public record VisitCreateCommand(String petId, String ownerId, LocalDate visitDate, String description) {}
