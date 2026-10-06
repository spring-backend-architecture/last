package dev.dmitriirussu.petclinic.web.application.query.view;

import java.util.List;

public record OwnerDetailsView(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone,
        List<PetDetailsView> pets
) {}
