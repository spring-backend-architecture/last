package dev.dmitriirussu.petclinic.web.application.command.service;

import dev.dmitriirussu.petclinic.web.application.command.client.PetCreateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.PetCreateCommand;
import dev.dmitriirussu.petclinic.web.application.command.usecase.PetCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetCreateService implements PetCreateUseCase {
    private final PetCreateClient petCreateClient;

    @Override
    public void create(PetCreateCommand command) {
        petCreateClient.create(command);
    }
}

