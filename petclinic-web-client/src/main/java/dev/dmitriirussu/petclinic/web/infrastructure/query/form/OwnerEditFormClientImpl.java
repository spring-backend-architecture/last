package dev.dmitriirussu.petclinic.web.infrastructure.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.OwnerEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.view.form.OwnerEditForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class OwnerEditFormClientImpl implements OwnerEditFormClient {

    private final RestClient restClient;

    @Override
    public OwnerEditForm findByOwnerId(String ownerId) {
        return restClient.get()
                .uri("/owners/{id}/edit", ownerId)
                .retrieve()
                .body(OwnerEditForm.class);
    }
}