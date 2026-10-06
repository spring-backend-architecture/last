package dev.dmitriirussu.petclinic.web.application.query.view.form;

public record OwnerEditForm(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone
) {}
