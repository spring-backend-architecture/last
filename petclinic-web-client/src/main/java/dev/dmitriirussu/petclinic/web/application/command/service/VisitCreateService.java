package dev.dmitriirussu.petclinic.web.application.command.service;

import dev.dmitriirussu.petclinic.web.application.command.client.VisitCreateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.VisitCreateCommand;
import dev.dmitriirussu.petclinic.web.application.command.usecase.VisitCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class VisitCreateService implements VisitCreateUseCase {
    private final VisitCreateClient visitCreateClient;

    @Override
    public void create(VisitCreateCommand command) {
        visitCreateClient.create(command);
    }
}

