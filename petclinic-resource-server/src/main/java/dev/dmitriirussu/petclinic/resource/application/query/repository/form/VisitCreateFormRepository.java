package dev.dmitriirussu.petclinic.resource.application.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.VisitCreateForm;

public interface VisitCreateFormRepository {
    VisitCreateForm findByPetId(String petId);
}