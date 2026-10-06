package dev.dmitriirussu.petclinic.web.application.query.view;

import java.time.LocalDate;

public record VisitView(
        String id,
        LocalDate visitDate,
        String description
) {}
