package dev.dmitriirussu.petclinic.resource.application.query.service.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.OwnerEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.VisitCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.VisitCreateFormUseCase;

public final class AllQueryFormServiceFactory {

    private AllQueryFormServiceFactory() {}

    public static OwnerEditFormUseCase ownerEditFormUseCase(
            OwnerEditFormRepository repository
    ) {
        return new OwnerEditFormService(repository);
    }

    public static PetCreateFormUseCase petCreateFormUseCase(
            PetCreateFormRepository repository
    ) {
        return new PetCreateFormService(repository);
    }

    public static PetEditFormUseCase petEditFormUseCase(
            PetEditFormRepository repository
    ) {
        return new PetEditFormService(repository);
    }

    public static VisitCreateFormUseCase visitCreateFormUseCase(
            VisitCreateFormRepository repository
    ) {
        return new VisitCreateFormService(repository);
    }
}

