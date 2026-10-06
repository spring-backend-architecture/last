package dev.dmitriirussu.petclinic.resource.application.command.usecase;

import dev.dmitriirussu.petclinic.resource.application.command.model.PetUpdateCommand;

public interface PetUpdateUseCase {
    void updatePet(PetUpdateCommand command);
}
