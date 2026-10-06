package dev.dmitriirussu.petclinic.web.application.command.usecase;

import dev.dmitriirussu.petclinic.web.application.command.model.VisitCreateCommand;

public interface VisitCreateUseCase {
    void create(VisitCreateCommand command);
}
