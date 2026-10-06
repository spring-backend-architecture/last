package dev.dmitriirussu.petclinic.web.application.command.service;

import dev.dmitriirussu.petclinic.web.application.command.client.OwnerCreateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.OwnerCreateCommand;
import dev.dmitriirussu.petclinic.web.application.command.usecase.OwnerCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerCreateService implements OwnerCreateUseCase {

    private final OwnerCreateClient ownerCreateClient;

    @Override
    public String create(OwnerCreateCommand command) {
        return ownerCreateClient.create(command);
    }
}
