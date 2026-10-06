package dev.dmitriirussu.petclinic.web.presentation.command.form;

import java.time.LocalDate;

import dev.dmitriirussu.petclinic.web.application.command.model.PetCreateCommand;
import dev.dmitriirussu.petclinic.web.application.command.model.PetUpdateCommand;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm;
import jakarta.validation.constraints.*;
import dev.dmitriirussu.petclinic.web.presentation.support.validation.ValidationMessages;

public class PetForm {

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters")
    @Pattern(regexp = ValidationMessages.NAME_REGEX, message = ValidationMessages.NAME_MESSAGE)
    private String name = "";

    @NotNull(message = "Birth date is required")
    @PastOrPresent(message = ValidationMessages.BIRTH_DATE_MESSAGE)
    private LocalDate birthDate;

    @NotBlank(message = "Type is required")
    private String type = "";

    @NotBlank(message = "Owner is required")
    private String ownerId = "";

    public PetForm() {}

    public static PetForm prefilledFrom(PetEditForm source) {
        PetForm form = new PetForm();
        form.name      = source.name();
        form.birthDate = source.birthDate();
        form.type      = source.type();
        form.ownerId   = source.ownerId();
        return form;
    }

    public PetCreateCommand toCreateCommand() {
        return new PetCreateCommand(name, birthDate, type, ownerId);
    }

    public PetUpdateCommand toUpdateCommand(String petId) {
        return new PetUpdateCommand(petId, name, birthDate, type, ownerId);
    }

    public String getBirthDateDisplay() {
        return birthDate != null ? birthDate.toString() : "";
    }

    public String getName()         { return name; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getType()         { return type; }
    public String getOwnerId()      { return ownerId; }

    public void setName(String name)              { this.name = name; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setType(String type)              { this.type = type; }
    public void setOwnerId(String ownerId)        { this.ownerId = ownerId; }
}
