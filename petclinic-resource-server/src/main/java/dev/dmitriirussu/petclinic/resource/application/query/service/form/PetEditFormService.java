package dev.dmitriirussu.petclinic.resource.application.query.service.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetEditForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetEditFormService implements PetEditFormUseCase {

    private final PetEditFormRepository petEditFormRepository;

    public PetEditForm findByPetId(String petId) {
        return petEditFormRepository.findByPetId(petId);
    }
}