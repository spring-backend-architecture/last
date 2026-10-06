package dev.dmitriirussu.petclinic.web.application.query.service.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.OwnerEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.form.OwnerEditForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerEditFormService implements OwnerEditFormUseCase {

    private final OwnerEditFormClient ownerEditFormClient;

    @Override
    public OwnerEditForm findByOwnerId(String ownerId) {
        return ownerEditFormClient.findByOwnerId(ownerId);
    }
}
