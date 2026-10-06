package dev.dmitriirussu.petclinic.web.application.query.usecase.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.PetCreateForm;

public interface PetCreateFormUseCase {
    PetCreateForm findByOwnerId(String ownerId);
}
