package dev.dmitriirussu.petclinic.resource.application.command.service;


import dev.dmitriirussu.petclinic.resource.application.command.model.OwnerUpdateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.repository.OwnerUpdateRepository;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.OwnerUpdateUseCase;
import dev.dmitriirussu.petclinic.resource.model.Owner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class OwnerUpdateService implements OwnerUpdateUseCase {

    private final OwnerUpdateRepository repository;

    public void updateOwner(OwnerUpdateCommand command) {
        repository.update(
                new Owner(
                        command.id(),
                        command.firstName(),
                        command.lastName(),
                        command.street(),
                        command.city(),
                        command.telephone()
                )
        );
    }
}
