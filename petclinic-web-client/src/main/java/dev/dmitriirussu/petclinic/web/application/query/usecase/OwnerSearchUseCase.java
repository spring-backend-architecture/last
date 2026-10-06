package dev.dmitriirussu.petclinic.web.application.query.usecase;

import dev.dmitriirussu.petclinic.web.application.query.PageResult;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerListView;

public interface OwnerSearchUseCase {
    PageResult<OwnerListView> search(String lastName, int page);
}
