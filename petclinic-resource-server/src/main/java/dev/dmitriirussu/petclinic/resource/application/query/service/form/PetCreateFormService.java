package dev.dmitriirussu.petclinic.resource.application.query.service.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetCreateForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetCreateFormService implements PetCreateFormUseCase {

    private final PetCreateFormRepository petCreateFormRepository;

    public PetCreateForm findByOwnerId(String ownerId) {
        return petCreateFormRepository.findByOwnerId(ownerId);
    }
}
