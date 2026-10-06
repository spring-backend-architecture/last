package dev.dmitriirussu.petclinic.resource.application.query.service.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.OwnerEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.OwnerEditForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerEditFormService implements OwnerEditFormUseCase {

    private final OwnerEditFormRepository ownerEditFormRepository;

    public OwnerEditForm findByOwnerId(String ownerId) {
        return ownerEditFormRepository.findByOwnerId(ownerId);
    }
}