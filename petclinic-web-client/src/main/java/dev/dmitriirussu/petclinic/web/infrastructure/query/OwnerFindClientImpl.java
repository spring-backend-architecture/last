package dev.dmitriirussu.petclinic.web.infrastructure.query;

import dev.dmitriirussu.petclinic.web.application.query.client.OwnerFindClient;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerDetailsView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class OwnerFindClientImpl implements OwnerFindClient {

    private final RestClient restClient;

    @Override
    public OwnerDetailsView findById(String id) {
        return restClient.get()
                .uri("/owners/{id}", id)
                .retrieve()
                .body(OwnerDetailsView.class);
    }
}
