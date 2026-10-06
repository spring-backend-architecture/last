package dev.dmitriirussu.petclinic.resource.application.query.view.form;

public record OwnerEditForm(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {}
