package dev.dmitriirussu.petclinic.web.application.query.service;

import dev.dmitriirussu.petclinic.web.application.query.PageResult;
import dev.dmitriirussu.petclinic.web.application.query.client.OwnerSearchClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.OwnerSearchUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerListView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerSearchService implements OwnerSearchUseCase {

    private final OwnerSearchClient ownerSearchClient;

    @Override
    public PageResult<OwnerListView> search(String lastName, int page) {
        return ownerSearchClient.search(lastName, page);
    }
}
