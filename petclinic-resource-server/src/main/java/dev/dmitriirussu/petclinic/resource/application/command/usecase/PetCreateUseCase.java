package dev.dmitriirussu.petclinic.resource.application.command.usecase;

import dev.dmitriirussu.petclinic.resource.application.command.model.PetCreateCommand;

public interface PetCreateUseCase {
    void createPet(PetCreateCommand command);
}
