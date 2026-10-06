package dev.dmitriirussu.petclinic.web.application.command.client;

import dev.dmitriirussu.petclinic.web.application.command.model.PetCreateCommand;

public interface PetCreateClient {
    void create(PetCreateCommand command);
}
