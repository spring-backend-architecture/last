package dev.dmitriirussu.petclinic.web.application.command.client;

import dev.dmitriirussu.petclinic.web.application.command.model.PetUpdateCommand;

public interface PetUpdateClient {
    void update(PetUpdateCommand command);
}
