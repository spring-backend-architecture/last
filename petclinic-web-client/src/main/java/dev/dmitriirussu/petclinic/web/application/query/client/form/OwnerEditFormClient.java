package dev.dmitriirussu.petclinic.web.application.query.client.form;

import dev.dmitriirussu.petclinic.web.application.query.view.form.OwnerEditForm;

public interface OwnerEditFormClient {
    OwnerEditForm findByOwnerId(String ownerId);
}
