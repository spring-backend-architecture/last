package dev.dmitriirussu.petclinic.resource.presentation.support.request;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record PetCreateOrEditRequest (
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters")
    @Pattern(regexp = ValidationMessages.NAME_REGEX, message = ValidationMessages.NAME_MESSAGE)
    String name,

    @NotNull(message = "Birth date is required")
    @PastOrPresent(message = ValidationMessages.BIRTH_DATE_MESSAGE)
    LocalDate birthDate,

    @NotBlank(message = "Type is required")
    String type,

    @NotBlank(message = "Owner is required")
    String ownerId
    ) {}
