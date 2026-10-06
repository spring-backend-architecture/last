package dev.dmitriirussu.petclinic.resource.infrastructure.query.repository;

import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerFindRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerSearchRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

public final class AllQueryRepositoryFactory {

    private AllQueryRepositoryFactory() {}

    public static OwnerFindRepository ownerFindRepository(JdbcClient jdbc) {
        return new OwnerFindRepositoryImpl(jdbc);
    }

    public static OwnerSearchRepository ownerSearchRepository(JdbcClient jdbc) {
        return new OwnerSearchRepositoryImpl(jdbc);
    }
}
