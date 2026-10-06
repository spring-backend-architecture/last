package dev.dmitriirussu.petclinic.resource.application.command.service;

import dev.dmitriirussu.petclinic.resource.application.command.repository.*;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.*;

public final class AllCommandServiceFactory {

    private AllCommandServiceFactory() {}

    public static OwnerCreateUseCase ownerCreateUseCase(
            OwnerCreateRepository repository
    ) {
        return new OwnerCreateService(repository);
    }

    public static OwnerUpdateUseCase ownerUpdateUseCase(
            OwnerUpdateRepository repository
    ) {
        return new OwnerUpdateService(repository);
    }

    public static PetCreateUseCase petCreateUseCase(
            PetCreateRepository repository
    ) {
        return new PetCreateService(repository);
    }

    public static PetUpdateUseCase petUpdateUseCase(
            PetUpdateRepository repository
    ) {
        return new PetUpdateService(repository);
    }

    public static VisitCreateUseCase visitCreateUseCase(
            VisitCreateRepository repository
    ) {
        return new VisitCreateService(repository);
    }
}