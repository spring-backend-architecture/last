package dev.dmitriirussu.petclinic.resource.application.query.view;

import java.time.LocalDate;
import java.util.List;

public record PetView(
        String id,
        String name,
        LocalDate birthDate,
        String type,
        List<VisitView> visits
) {
    public PetView {
        visits = List.copyOf(visits);
    }
}