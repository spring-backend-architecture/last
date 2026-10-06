package dev.dmitriirussu.petclinic.resource.application.query.usecase.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetCreateForm;

public interface PetCreateFormUseCase {
    PetCreateForm findByOwnerId(String ownerId);
}
