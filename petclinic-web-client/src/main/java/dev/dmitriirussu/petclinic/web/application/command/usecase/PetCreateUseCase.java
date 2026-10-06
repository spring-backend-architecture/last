package dev.dmitriirussu.petclinic.web.application.command.usecase;

import dev.dmitriirussu.petclinic.web.application.command.model.PetCreateCommand;

public interface PetCreateUseCase {
    void create(PetCreateCommand command);
}
