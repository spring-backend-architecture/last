package dev.dmitriirussu.petclinic.resource.application.query.usecase;

import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerView;

public interface OwnerFindUseCase {
    OwnerView findById(String id);
}
