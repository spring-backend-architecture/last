package dev.dmitriirussu.petclinic.resource.application.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetEditForm;

public interface PetEditFormRepository {
    PetEditForm findByPetId(String petId);
}
