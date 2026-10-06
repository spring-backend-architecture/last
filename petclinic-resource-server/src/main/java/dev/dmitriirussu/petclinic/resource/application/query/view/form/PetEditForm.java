package dev.dmitriirussu.petclinic.resource.application.query.view.form;

import java.time.LocalDate;
import java.util.List;

public record PetEditForm(
        String id,
        String name,
        LocalDate birthDate,
        String type,
        String ownerId,
        String firstName,
        String lastName,
        List<String> petTypes
) {
    public PetEditForm {
        petTypes = List.copyOf(petTypes);
    }
}