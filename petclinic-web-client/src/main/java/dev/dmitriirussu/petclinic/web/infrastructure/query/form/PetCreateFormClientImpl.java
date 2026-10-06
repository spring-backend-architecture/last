package dev.dmitriirussu.petclinic.web.infrastructure.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.PetCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class PetCreateFormClientImpl implements PetCreateFormClient {

    private final RestClient restClient;

    @Override
    public PetCreateForm findByOwnerId(String ownerId) {
        return restClient.get()
                .uri("/pets/new?ownerId={ownerId}", ownerId)
                .retrieve()
                .body(PetCreateForm.class);
    }
}
