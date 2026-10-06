package dev.dmitriirussu.petclinic.resource.application.query.usecase.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.VisitCreateForm;

public interface VisitCreateFormUseCase {
    VisitCreateForm findByPetId(String petId);
}
