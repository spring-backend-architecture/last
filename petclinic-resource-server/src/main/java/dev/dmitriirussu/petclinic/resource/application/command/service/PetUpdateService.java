package dev.dmitriirussu.petclinic.resource.application.command.service;

import dev.dmitriirussu.petclinic.resource.application.command.model.PetUpdateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.repository.PetUpdateRepository;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.PetUpdateUseCase;
import dev.dmitriirussu.petclinic.resource.model.Pet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class PetUpdateService implements PetUpdateUseCase {

    private final PetUpdateRepository repository;

    public void updatePet(PetUpdateCommand command) {

        repository.update(
                new Pet(
                        command.id(),
                        command.name(),
                        command.birthDate(),
                        command.type(),
                        command.ownerId()
                )
        );
    }
}