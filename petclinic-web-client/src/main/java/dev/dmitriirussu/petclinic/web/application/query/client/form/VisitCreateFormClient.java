package dev.dmitriirussu.petclinic.web.application.query.client.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.VisitCreateForm;

public interface VisitCreateFormClient {
    VisitCreateForm findByPetId(String petId);
}
