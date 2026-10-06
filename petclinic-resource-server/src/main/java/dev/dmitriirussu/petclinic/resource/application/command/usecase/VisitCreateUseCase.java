package dev.dmitriirussu.petclinic.resource.application.command.usecase;

import dev.dmitriirussu.petclinic.resource.application.command.model.VisitCreateCommand;

public interface VisitCreateUseCase {
    void create(VisitCreateCommand command);
}
