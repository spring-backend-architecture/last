package dev.dmitriirussu.petclinic.resource.presentation.support.request;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record VisitCreateRequest (
    @NotNull(message = "Date is required")
    @FutureOrPresent(message = ValidationMessages.VISIT_DATE_MESSAGE)
    LocalDate visitDate,

    @NotBlank(message = "Description is required")
    @Size(min = 1, max = 255, message = "Description must be between 1 and 255 characters")
    String description
    ) {}