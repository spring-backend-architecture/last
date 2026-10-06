package dev.dmitriirussu.petclinic.resource.application.query.view;

import java.util.List;

public record OwnerView(
        String id,
        String firstName,
        String lastName,
        String street,
        String city,
        String telephone,
        List<PetView> pets
) {
    public OwnerView { pets = List.copyOf(pets); }
}
