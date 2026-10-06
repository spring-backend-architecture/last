package dev.dmitriirussu.petclinic.resource.infrastructure.bootstrap;

import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerFindRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerSearchRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.OwnerEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.repository.form.VisitCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.service.AllQueryServiceFactory;
import dev.dmitriirussu.petclinic.resource.application.query.service.form.AllQueryFormServiceFactory;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerSearchUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.VisitCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.repository.AllQueryRepositoryFactory;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.repository.form.AllQueryFormRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
class QueryConfig {

    // --- repositories ---
    @Bean
    OwnerFindRepository ownerFindRepository(JdbcClient jdbc) {
        return AllQueryRepositoryFactory.ownerFindRepository(jdbc);
    }

    @Bean
    OwnerSearchRepository ownerSearchRepository(JdbcClient jdbc) {
        return AllQueryRepositoryFactory.ownerSearchRepository(jdbc);
    }

    @Bean
    OwnerEditFormRepository ownerEditFormRepository(JdbcClient jdbc) {
        return AllQueryFormRepositoryFactory.ownerEditFormRepository(jdbc);
    }

    @Bean
    PetCreateFormRepository petCreateFormRepository(JdbcClient jdbc) {
        return AllQueryFormRepositoryFactory.petCreateFormRepository(jdbc);
    }

    @Bean
    PetEditFormRepository petEditFormRepository(JdbcClient jdbc) {
        return AllQueryFormRepositoryFactory.petEditFormRepository(jdbc);
    }

    @Bean
    VisitCreateFormRepository visitCreateFormRepository(JdbcClient jdbc) {
        return AllQueryFormRepositoryFactory.visitCreateFormRepository(jdbc);
    }

    // --- use cases ---
    @Bean
    OwnerFindUseCase ownerFindUseCase(OwnerFindRepository repository) {
        return AllQueryServiceFactory.ownerFindUseCase(repository);
    }

    @Bean
    OwnerSearchUseCase ownerSearchUseCase(OwnerSearchRepository repository) {
        return AllQueryServiceFactory.ownerSearchUseCase(repository);
    }

    @Bean
    OwnerEditFormUseCase ownerEditFormUseCase(OwnerEditFormRepository repository) {
        return AllQueryFormServiceFactory.ownerEditFormUseCase(repository);
    }

    @Bean
    PetCreateFormUseCase petCreateFormUseCase(PetCreateFormRepository repository) {
        return AllQueryFormServiceFactory.petCreateFormUseCase(repository);
    }

    @Bean
    PetEditFormUseCase petEditFormUseCase(PetEditFormRepository repository) {
        return AllQueryFormServiceFactory.petEditFormUseCase(repository);
    }

    @Bean
    VisitCreateFormUseCase visitCreateFormUseCase(VisitCreateFormRepository repository) {
        return AllQueryFormServiceFactory.visitCreateFormUseCase(repository);
    }
}