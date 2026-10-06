package dev.dmitriirussu.petclinic.web.application.query.service.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.PetEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetEditFormService implements PetEditFormUseCase {

    private final PetEditFormClient petEditFormClient;

    @Override
    public PetEditForm findByPetId(String petId) {
        return petEditFormClient.findByPetId(petId);
    }
}
