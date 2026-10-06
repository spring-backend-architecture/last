package dev.dmitriirussu.petclinic.web.application.query.service.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.VisitCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.VisitCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.form.VisitCreateForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class VisitCreateFormService implements VisitCreateFormUseCase {

    private final VisitCreateFormClient visitCreateFormClient;

    @Override
    public VisitCreateForm findByPetId(String petId) {
        return visitCreateFormClient.findByPetId(petId);
    }
}

