package dev.dmitriirussu.petclinic.web.infrastructure.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.PetEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class PetEditFormClientImpl implements PetEditFormClient {

    private final RestClient restClient;

    @Override
    public PetEditForm findByPetId(String petId) {
        return restClient.get()
                .uri("/pets/{petId}/edit", petId)
                .retrieve()
                .body(PetEditForm.class);
    }
}

