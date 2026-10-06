package dev.dmitriirussu.petclinic.web.infrastructure.query;

import dev.dmitriirussu.petclinic.web.application.query.client.OwnerFindClient;
import dev.dmitriirussu.petclinic.web.application.query.client.OwnerSearchClient;
import org.springframework.web.client.RestClient;

public final class AllQueryClientFactory {

    private AllQueryClientFactory() {}

    public static OwnerSearchClient ownerSearchClient(RestClient restClient) {
        return new OwnerSearchClientImpl(restClient);
    }

    public static OwnerFindClient ownerFindClient(RestClient restClient) {
        return new OwnerFindClientImpl(restClient);
    }
}