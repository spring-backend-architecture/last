package dev.dmitriirussu.petclinic.resource.application.query.repository;

import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerView;

public interface OwnerFindRepository {
    OwnerView findById(String id);
}
