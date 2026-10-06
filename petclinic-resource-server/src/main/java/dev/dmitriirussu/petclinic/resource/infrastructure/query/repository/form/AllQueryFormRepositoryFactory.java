package dev.dmitriirussu.petclinic.resource.infrastructure.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.OwnerEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.VisitCreateFormRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

public final class AllQueryFormRepositoryFactory {

    private AllQueryFormRepositoryFactory() {}

    public static OwnerEditFormRepository ownerEditFormRepository(JdbcClient jdbc) {
        return new OwnerEditFormRepositoryImpl(jdbc);
    }

    public static PetCreateFormRepository petCreateFormRepository(JdbcClient jdbc) {
        return new PetCreateFormRepositoryImpl(jdbc);
    }

    public static PetEditFormRepository petEditFormRepository(JdbcClient jdbc) {
        return new PetEditFormRepositoryImpl(jdbc);
    }

    public static VisitCreateFormRepository visitCreateFormRepository(JdbcClient jdbc) {
        return new VisitCreateFormRepositoryImpl(jdbc);
    }
}

