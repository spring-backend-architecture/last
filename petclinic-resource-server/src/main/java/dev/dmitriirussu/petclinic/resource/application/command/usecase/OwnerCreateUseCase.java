package dev.dmitriirussu.petclinic.resource.application.command.usecase;

import dev.dmitriirussu.petclinic.resource.application.command.model.OwnerCreateCommand;

public interface OwnerCreateUseCase {
    String createOwner(OwnerCreateCommand command);
}
