package dev.dmitriirussu.petclinic.web.application.command.model;

import java.util.Objects;

public record OwnerCreateCommand(
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {

    public OwnerCreateCommand {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(street);
        Objects.requireNonNull(city);
        Objects.requireNonNull(telephone);
    }
}
