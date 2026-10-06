package dev.dmitriirussu.petclinic.web.application.query.client.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm;

public interface PetEditFormClient {
    PetEditForm findByPetId(String petId);
}
