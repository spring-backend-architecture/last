package dev.dmitriirussu.petclinic.web.infrastructure.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.VisitCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.view.form.VisitCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class VisitCreateFormClientImpl implements VisitCreateFormClient {

    private final RestClient restClient;

    @Override
    public VisitCreateForm findByPetId(String petId) {
        return restClient.get()
                .uri("/visits/new?petId={petId}", petId)
                .retrieve()
                .body(VisitCreateForm.class);
    }
}
