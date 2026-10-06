package dev.dmitriirussu.petclinic.resource.application.command.model;

public record OwnerUpdateCommand(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {}
