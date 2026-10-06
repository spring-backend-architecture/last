package dev.dmitriirussu.petclinic.web.application.command.usecase;

import dev.dmitriirussu.petclinic.web.application.command.model.PetUpdateCommand;

public interface PetUpdateUseCase {
    void update(PetUpdateCommand command);
}
