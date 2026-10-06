package dev.dmitriirussu.petclinic.web.infrastructure.bootstrap;

import dev.dmitriirussu.petclinic.web.application.command.client.*;
import dev.dmitriirussu.petclinic.web.application.command.service.AllCommandServiceFactory;
import dev.dmitriirussu.petclinic.web.application.command.usecase.*;
import dev.dmitriirussu.petclinic.web.infrastructure.command.AllCommandClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class CommandConfig {

    // --- clients ---
    @Bean
    OwnerCreateClient ownerCreateClient(RestClient restClient) {
        return AllCommandClientFactory.ownerCreateClient(restClient);
    }

    @Bean
    OwnerUpdateClient ownerUpdateClient(RestClient restClient) {
        return AllCommandClientFactory.ownerUpdateClient(restClient);
    }

    @Bean
    PetCreateClient petCreateClient(RestClient restClient) {
        return AllCommandClientFactory.petCreateClient(restClient);
    }

    @Bean
    PetUpdateClient petUpdateClient(RestClient restClient) {
        return AllCommandClientFactory.petUpdateClient(restClient);
    }

    @Bean
    VisitCreateClient visitCreateClient(RestClient restClient) {
        return AllCommandClientFactory.visitCreateClient(restClient);
    }

    // --- use cases ---
    @Bean
    OwnerCreateUseCase ownerCreateUseCase(OwnerCreateClient client) {
        return AllCommandServiceFactory.ownerCreateUseCase(client);
    }

    @Bean
    OwnerUpdateUseCase ownerUpdateUseCase(OwnerUpdateClient client) {
        return AllCommandServiceFactory.ownerUpdateUseCase(client);
    }

    @Bean
    PetCreateUseCase petCreateUseCase(PetCreateClient client) {
        return AllCommandServiceFactory.petCreateUseCase(client);
    }

    @Bean
    PetUpdateUseCase petUpdateUseCase(PetUpdateClient client) {
        return AllCommandServiceFactory.petUpdateUseCase(client);
    }

    @Bean
    VisitCreateUseCase visitCreateUseCase(VisitCreateClient client) {
        return AllCommandServiceFactory.visitCreateUseCase(client);
    }
}
