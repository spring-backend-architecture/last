package dev.dmitriirussu.petclinic.web.presentation.command.form;

import dev.dmitriirussu.petclinic.web.application.command.model.VisitCreateCommand;
import dev.dmitriirussu.petclinic.web.presentation.support.validation.ValidationMessages;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class VisitForm {

    @NotNull(message = "Date is required")
    @FutureOrPresent(message = ValidationMessages.VISIT_DATE_MESSAGE)
    private LocalDate visitDate;

    @NotBlank(message = "Description is required")
    @Size(min = 1, max = 255, message = "Description must be between 1 and 255 characters")
    private String description = "";

    public VisitForm() {}

    public VisitCreateCommand toCreateCommand(String petId, String ownerId) {
        return new VisitCreateCommand(petId, ownerId, visitDate, description);
    }

    public String getVisitDateDisplay() {
        return visitDate != null ? visitDate.toString() : "";
    }

    public LocalDate getVisitDate() { return visitDate; }
    public String getDescription()  { return description; }

    public void setVisitDate(LocalDate visitDate)  { this.visitDate = visitDate; }
    public void setDescription(String description) { this.description = description; }
}
