package dev.dmitriirussu.petclinic.resource.model;

public record Owner(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {}
