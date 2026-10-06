package dev.dmitriirussu.petclinic.resource.application.query.service;

import dev.dmitriirussu.petclinic.resource.application.query.OwnerSearchCriteria;
import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerSearchRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerSearchUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerListView;
import dev.dmitriirussu.petclinic.resource.presentation.support.pagination.PageQuery;
import dev.dmitriirussu.petclinic.resource.presentation.support.pagination.PageResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerSearchService implements OwnerSearchUseCase {
    private final OwnerSearchRepository repository;

    public PageResult<OwnerListView> search(OwnerSearchCriteria criteria, PageQuery query) {
        var result = repository.search(criteria, query);
        if (query.page() > result.totalPages() && result.total() > 0) {
            return PageResult.empty(query, result.total());
        }
        return result;
    }
}