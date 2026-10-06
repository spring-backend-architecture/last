package dev.dmitriirussu.petclinic.web.application.command.client;

import dev.dmitriirussu.petclinic.web.application.command.model.VisitCreateCommand;

public interface VisitCreateClient {
    void create(VisitCreateCommand command);
}
