package dev.dmitriirussu.petclinic.resource.application.query.usecase.form;


import dev.dmitriirussu.petclinic.resource.application.query.view.form.OwnerEditForm;

public interface OwnerEditFormUseCase {
    OwnerEditForm findByOwnerId(String ownerId);
}
