package dev.dmitriirussu.petclinic.web.application.query.client;

import dev.dmitriirussu.petclinic.web.application.query.PageResult;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerListView;

public interface OwnerSearchClient {
    PageResult<OwnerListView> search(String lastName, int page);
}
