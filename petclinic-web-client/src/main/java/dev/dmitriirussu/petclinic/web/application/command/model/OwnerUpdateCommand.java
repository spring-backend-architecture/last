package dev.dmitriirussu.petclinic.web.application.command.model;

import java.util.Objects;

public record OwnerUpdateCommand(
        String ownerId,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {
    public OwnerUpdateCommand {
        Objects.requireNonNull(ownerId);
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(street);
        Objects.requireNonNull(city);
        Objects.requireNonNull(telephone);
    }
}
