package dev.dmitriirussu.petclinic.web.application.query.service.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.OwnerEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.PetCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.PetEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.VisitCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.VisitCreateFormUseCase;

public final class AllQueryFormServiceFactory {

    private AllQueryFormServiceFactory() {}

    public static OwnerEditFormUseCase ownerEditFormUseCase(OwnerEditFormClient client) {
        return new OwnerEditFormService(client);
    }

    public static PetCreateFormUseCase petCreateFormUseCase(PetCreateFormClient client) {
        return new PetCreateFormService(client);
    }

    public static PetEditFormUseCase petEditFormUseCase(PetEditFormClient client) {
        return new PetEditFormService(client);
    }

    public static VisitCreateFormUseCase visitCreateFormUseCase(VisitCreateFormClient client) {
        return new VisitCreateFormService(client);
    }
}