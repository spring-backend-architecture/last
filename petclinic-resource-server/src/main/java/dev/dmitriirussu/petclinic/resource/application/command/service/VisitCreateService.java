package dev.dmitriirussu.petclinic.resource.application.command.service;

import dev.dmitriirussu.petclinic.resource.application.command.model.VisitCreateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.VisitCreateUseCase;
import dev.dmitriirussu.petclinic.resource.application.command.repository.VisitCreateRepository;
import dev.dmitriirussu.petclinic.resource.model.Visit;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
final class VisitCreateService implements VisitCreateUseCase {

    private final VisitCreateRepository repository;

    public void create(VisitCreateCommand command) {

        Visit visit = new Visit(
                UUID.randomUUID().toString(),
                command.visitDate(),
                command.description(),
                command.petId()
        );
        repository.create(visit, command.ownerId());
    }
}