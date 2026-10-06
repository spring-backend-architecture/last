package dev.dmitriirussu.petclinic.web.application.command.service;

import dev.dmitriirussu.petclinic.web.application.command.client.*;
import dev.dmitriirussu.petclinic.web.application.command.usecase.*;

public final class AllCommandServiceFactory {

    private AllCommandServiceFactory() {}

    public static OwnerCreateUseCase ownerCreateUseCase(OwnerCreateClient client) {
        return new OwnerCreateService(client);
    }

    public static OwnerUpdateUseCase ownerUpdateUseCase(OwnerUpdateClient client) {
        return new OwnerUpdateService(client);
    }

    public static PetCreateUseCase petCreateUseCase(PetCreateClient client) {
        return new PetCreateService(client);
    }

    public static PetUpdateUseCase petUpdateUseCase(PetUpdateClient client) {
        return new PetUpdateService(client);
    }

    public static VisitCreateUseCase visitCreateUseCase(VisitCreateClient client) {
        return new VisitCreateService(client);
    }
}