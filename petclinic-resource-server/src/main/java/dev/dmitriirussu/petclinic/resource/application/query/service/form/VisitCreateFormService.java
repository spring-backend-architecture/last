package dev.dmitriirussu.petclinic.resource.application.query.service.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.VisitCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.VisitCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.VisitCreateForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class VisitCreateFormService implements VisitCreateFormUseCase {

    private final VisitCreateFormRepository visitCreateFormRepository;

    public VisitCreateForm findByPetId(String petId) {
        return visitCreateFormRepository.findByPetId(petId);
    }
}