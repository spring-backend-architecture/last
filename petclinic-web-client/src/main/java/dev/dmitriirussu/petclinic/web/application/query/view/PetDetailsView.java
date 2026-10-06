package dev.dmitriirussu.petclinic.web.application.query.view;

import java.time.LocalDate;
import java.util.List;

public record PetDetailsView(
        String id,
        String name,
        LocalDate birthDate,
        String type,
        List<VisitView> visits
) {}
