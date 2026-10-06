package dev.dmitriirussu.petclinic.web.application.query.service;

import dev.dmitriirussu.petclinic.web.application.query.client.OwnerFindClient;
import dev.dmitriirussu.petclinic.web.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerDetailsView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerFindService implements OwnerFindUseCase {

    private final OwnerFindClient ownerFindClient;

    @Override
    public OwnerDetailsView findById(String id) {
        return ownerFindClient.findById(id);
    }
}
