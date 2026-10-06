package dev.dmitriirussu.petclinic.web.infrastructure.command;

import dev.dmitriirussu.petclinic.web.application.command.client.*;
import org.springframework.web.client.RestClient;

public final class AllCommandClientFactory {

    private AllCommandClientFactory() {}

    public static OwnerCreateClient ownerCreateClient(RestClient restClient) {
        return new OwnerCreateClientImpl(restClient);
    }

    public static OwnerUpdateClient ownerUpdateClient(RestClient restClient) {
        return new OwnerUpdateClientImpl(restClient);
    }

    public static PetCreateClient petCreateClient(RestClient restClient) {
        return new PetCreateClientImpl(restClient);
    }

    public static PetUpdateClient petUpdateClient(RestClient restClient) {
        return new PetUpdateClientImpl(restClient);
    }

    public static VisitCreateClient visitCreateClient(RestClient restClient) {
        return new VisitCreateClientImpl(restClient);
    }
}
