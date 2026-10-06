package dev.dmitriirussu.petclinic.resource.application.query.view;

import java.util.List;

public record OwnerListView(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone,
        List<String> petNames
) {
    public OwnerListView { petNames = List.copyOf(petNames); }
}
