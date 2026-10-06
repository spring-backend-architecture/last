package dev.dmitriirussu.petclinic.web.application.query.usecase.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm;

public interface PetEditFormUseCase {
    PetEditForm findByPetId(String petId);
}
