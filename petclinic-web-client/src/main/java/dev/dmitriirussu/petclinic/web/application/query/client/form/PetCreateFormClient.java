package dev.dmitriirussu.petclinic.web.application.query.client.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.PetCreateForm;

public interface PetCreateFormClient {
    PetCreateForm findByOwnerId(String ownerId);
}
