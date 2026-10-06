package dev.dmitriirussu.petclinic.web.infrastructure.query;


import dev.dmitriirussu.petclinic.web.application.query.PageResult;
import dev.dmitriirussu.petclinic.web.application.query.client.OwnerSearchClient;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerListView;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@RequiredArgsConstructor
final class OwnerSearchClientImpl implements OwnerSearchClient {

    private final RestClient restClient;

    @Override
    public PageResult<OwnerListView> search(String lastName, int page) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/owners/search")
                        .queryParamIfPresent("lastName", Optional.ofNullable(lastName))
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<PageResult<OwnerListView>>() {});
    }
}