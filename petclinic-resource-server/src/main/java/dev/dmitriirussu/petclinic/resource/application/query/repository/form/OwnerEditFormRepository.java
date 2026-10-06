package dev.dmitriirussu.petclinic.resource.application.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.view.form.OwnerEditForm;

public interface OwnerEditFormRepository {
    OwnerEditForm findByOwnerId(String ownerId);
}