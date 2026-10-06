package dev.dmitriirussu.petclinic.web.application.query.view.form;

import java.util.List;

public record PetCreateForm(
        String ownerId,
        String ownerFirstName,
        String ownerLastName,
        List<String> petTypes
) {
    public PetCreateForm {
        petTypes = List.copyOf(petTypes);
    }
}
