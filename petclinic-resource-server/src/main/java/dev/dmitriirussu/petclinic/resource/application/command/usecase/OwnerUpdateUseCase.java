package dev.dmitriirussu.petclinic.resource.application.command.usecase;

import dev.dmitriirussu.petclinic.resource.application.command.model.OwnerUpdateCommand;

public interface OwnerUpdateUseCase {
    void updateOwner(OwnerUpdateCommand command);
}
