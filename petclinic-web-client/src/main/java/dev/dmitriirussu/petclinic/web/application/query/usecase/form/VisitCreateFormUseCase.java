package dev.dmitriirussu.petclinic.web.application.query.usecase.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.VisitCreateForm;

public interface VisitCreateFormUseCase {
    VisitCreateForm findByPetId(String petId);
}
