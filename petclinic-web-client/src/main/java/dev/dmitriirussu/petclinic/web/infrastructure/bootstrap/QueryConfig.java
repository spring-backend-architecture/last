package dev.dmitriirussu.petclinic.web.infrastructure.bootstrap;

import dev.dmitriirussu.petclinic.web.application.query.client.OwnerFindClient;
import dev.dmitriirussu.petclinic.web.application.query.client.OwnerSearchClient;
import dev.dmitriirussu.petclinic.web.application.query.service.AllQueryServiceFactory;
import dev.dmitriirussu.petclinic.web.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.OwnerSearchUseCase;
import dev.dmitriirussu.petclinic.web.infrastructure.query.AllQueryClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class QueryConfig {

    @Bean
    OwnerSearchClient ownerSearchClient(RestClient restClient) {
        return AllQueryClientFactory.ownerSearchClient(restClient);
    }

    @Bean
    OwnerFindClient ownerFindClient(RestClient restClient) {
        return AllQueryClientFactory.ownerFindClient(restClient);
    }

    @Bean
    OwnerSearchUseCase ownerSearchUseCase(OwnerSearchClient client) {
        return AllQueryServiceFactory.ownerSearchUseCase(client);
    }

    @Bean
    OwnerFindUseCase ownerFindUseCase(OwnerFindClient client) {
        return AllQueryServiceFactory.ownerFindUseCase(client);
    }
}
