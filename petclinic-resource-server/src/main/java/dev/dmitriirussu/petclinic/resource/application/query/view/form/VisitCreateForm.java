package dev.dmitriirussu.petclinic.resource.application.query.view.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.VisitView;

import java.time.LocalDate;
import java.util.List;

public record VisitCreateForm(
        String petId,
        String petName,
        LocalDate birthDate,
        String type,
        String ownerId,
        String ownerFirstName,
        String ownerLastName,
        List<VisitView> visits
) {
    public VisitCreateForm {
        visits = List.copyOf(visits);
    }
}
