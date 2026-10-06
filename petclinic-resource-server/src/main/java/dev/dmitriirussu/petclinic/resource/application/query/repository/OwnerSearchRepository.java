package dev.dmitriirussu.petclinic.resource.application.query.repository;

import dev.dmitriirussu.petclinic.resource.application.query.OwnerSearchCriteria;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerListView;
import dev.dmitriirussu.petclinic.resource.presentation.support.pagination.PageQuery;
import dev.dmitriirussu.petclinic.resource.presentation.support.pagination.PageResult;

public interface OwnerSearchRepository {
    PageResult<OwnerListView> search(OwnerSearchCriteria criteria, PageQuery query);
}