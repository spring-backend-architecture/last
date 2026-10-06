package dev.dmitriirussu.petclinic.web.application.command.service;


import dev.dmitriirussu.petclinic.web.application.command.client.OwnerUpdateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.OwnerUpdateCommand;
import dev.dmitriirussu.petclinic.web.application.command.usecase.OwnerUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerUpdateService implements OwnerUpdateUseCase {

    private final OwnerUpdateClient ownerUpdateClient;

    @Override
    public void update(OwnerUpdateCommand command) {
        ownerUpdateClient.update(command);
    }
}

