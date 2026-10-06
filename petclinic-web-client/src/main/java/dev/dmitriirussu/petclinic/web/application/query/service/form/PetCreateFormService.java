package dev.dmitriirussu.petclinic.web.application.query.service.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.PetCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetCreateForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetCreateFormService implements PetCreateFormUseCase {

    private final PetCreateFormClient petCreateFormClient;

    @Override
    public PetCreateForm findByOwnerId(String ownerId) {
        return petCreateFormClient.findByOwnerId(ownerId);
    }
}

