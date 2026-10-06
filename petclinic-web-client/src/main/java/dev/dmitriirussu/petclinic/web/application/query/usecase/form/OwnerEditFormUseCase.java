package dev.dmitriirussu.petclinic.web.application.query.usecase.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.OwnerEditForm;

public interface OwnerEditFormUseCase {
    OwnerEditForm findByOwnerId(String ownerId);
}
