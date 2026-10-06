package dev.dmitriirussu.petclinic.web.infrastructure.bootstrap;

import dev.dmitriirussu.petclinic.web.application.query.client.form.OwnerEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.PetCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.PetEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.VisitCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.service.form.AllQueryFormServiceFactory;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.VisitCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.infrastructure.query.form.AllQueryFormClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class QueryFormConfig {

    @Bean
    OwnerEditFormClient ownerEditFormClient(RestClient restClient) {
        return AllQueryFormClientFactory.ownerEditFormClient(restClient);
    }

    @Bean
    PetCreateFormClient petCreateFormClient(RestClient restClient) {
        return AllQueryFormClientFactory.petCreateFormClient(restClient);
    }

    @Bean
    PetEditFormClient petEditFormClient(RestClient restClient) {
        return AllQueryFormClientFactory.petEditFormClient(restClient);
    }

    @Bean
    VisitCreateFormClient visitCreateFormClient(RestClient restClient) {
        return AllQueryFormClientFactory.visitCreateFormClient(restClient);
    }

    @Bean
    OwnerEditFormUseCase ownerEditFormUseCase(OwnerEditFormClient client) {
        return AllQueryFormServiceFactory.ownerEditFormUseCase(client);
    }

    @Bean
    PetCreateFormUseCase petCreateFormUseCase(PetCreateFormClient client) {
        return AllQueryFormServiceFactory.petCreateFormUseCase(client);
    }

    @Bean
    PetEditFormUseCase petEditFormUseCase(PetEditFormClient client) {
        return AllQueryFormServiceFactory.petEditFormUseCase(client);
    }

    @Bean
    VisitCreateFormUseCase visitCreateFormUseCase(VisitCreateFormClient client) {
        return AllQueryFormServiceFactory.visitCreateFormUseCase(client);
    }
}
