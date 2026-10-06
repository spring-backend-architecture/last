package dev.dmitriirussu.petclinic.web.infrastructure.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.OwnerEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.PetCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.PetEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.client.form.VisitCreateFormClient;
import org.springframework.web.client.RestClient;

public final class AllQueryFormClientFactory {

    private AllQueryFormClientFactory() {}

    public static OwnerEditFormClient ownerEditFormClient(RestClient restClient) {
        return new OwnerEditFormClientImpl(restClient);
    }

    public static PetCreateFormClient petCreateFormClient(RestClient restClient) {
        return new PetCreateFormClientImpl(restClient);
    }

    public static PetEditFormClient petEditFormClient(RestClient restClient) {
        return new PetEditFormClientImpl(restClient);
    }

    public static VisitCreateFormClient visitCreateFormClient(RestClient restClient) {
        return new VisitCreateFormClientImpl(restClient);
    }
}