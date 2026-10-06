package dev.dmitriirussu.petclinic.web.application.command.usecase;

import dev.dmitriirussu.petclinic.web.application.command.model.OwnerUpdateCommand;

public interface OwnerUpdateUseCase {
    void update(OwnerUpdateCommand command);
}
