package dev.dmitriirussu.petclinic.web.application.command.service;

import dev.dmitriirussu.petclinic.web.application.command.client.PetUpdateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.PetUpdateCommand;
import dev.dmitriirussu.petclinic.web.application.command.usecase.PetUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetUpdateService implements PetUpdateUseCase {
    private final PetUpdateClient petUpdateClient;

    @Override
    public void update(PetUpdateCommand command) {
        petUpdateClient.update(command);
    }
}
