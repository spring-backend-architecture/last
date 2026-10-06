package dev.dmitriirussu.petclinic.resource.application.query.service;

import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerFindRepository;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerFindService implements OwnerFindUseCase {
    private final OwnerFindRepository repository;

    public OwnerView findById(String id) {
        return repository.findById(id);
    }
}