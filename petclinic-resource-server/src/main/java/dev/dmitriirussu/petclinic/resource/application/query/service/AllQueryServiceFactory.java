package dev.dmitriirussu.petclinic.resource.application.query.service;

import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerFindRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerSearchRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerSearchUseCase;

public final class AllQueryServiceFactory {

    private AllQueryServiceFactory() {}

    public static OwnerFindUseCase ownerFindUseCase(
            OwnerFindRepository repository
    ) {
        return new OwnerFindService(repository);
    }

    public static OwnerSearchUseCase ownerSearchUseCase(
            OwnerSearchRepository repository
    ) {
        return new OwnerSearchService(repository);
    }
}
