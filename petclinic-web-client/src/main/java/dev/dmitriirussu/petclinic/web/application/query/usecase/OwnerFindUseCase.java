package dev.dmitriirussu.petclinic.web.application.query.usecase;

import dev.dmitriirussu.petclinic.web.application.query.view.OwnerDetailsView;

public interface OwnerFindUseCase {
    OwnerDetailsView findById(String id);
}
