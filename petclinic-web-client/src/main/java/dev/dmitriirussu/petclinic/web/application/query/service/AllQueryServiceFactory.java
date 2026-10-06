package dev.dmitriirussu.petclinic.web.application.query.service;

import dev.dmitriirussu.petclinic.web.application.query.client.OwnerFindClient;
import dev.dmitriirussu.petclinic.web.application.query.client.OwnerSearchClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.OwnerSearchUseCase;

public final class AllQueryServiceFactory {

    private AllQueryServiceFactory() {}

    public static OwnerFindUseCase ownerFindUseCase(OwnerFindClient client) {
        return new OwnerFindService(client);
    }

    public static OwnerSearchUseCase ownerSearchUseCase(OwnerSearchClient client) {
        return new OwnerSearchService(client);
    }
}