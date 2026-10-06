package dev.dmitriirussu.petclinic.resource.application.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetCreateForm;

public interface PetCreateFormRepository {
    PetCreateForm findByOwnerId(String ownerId);
}

