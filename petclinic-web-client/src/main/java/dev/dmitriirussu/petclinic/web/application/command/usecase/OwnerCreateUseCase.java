package dev.dmitriirussu.petclinic.web.application.command.usecase;

import dev.dmitriirussu.petclinic.web.application.command.model.OwnerCreateCommand;

public interface OwnerCreateUseCase {
    String create(OwnerCreateCommand command);
}
