package dev.dmitriirussu.petclinic.resource.application.query.usecase.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetEditForm;

public interface PetEditFormUseCase {
    PetEditForm findByPetId(String petId);
}
