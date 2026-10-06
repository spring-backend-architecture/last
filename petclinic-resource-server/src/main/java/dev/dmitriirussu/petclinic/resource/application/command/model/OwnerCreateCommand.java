package dev.dmitriirussu.petclinic.resource.application.command.model;

public record OwnerCreateCommand(
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {}
