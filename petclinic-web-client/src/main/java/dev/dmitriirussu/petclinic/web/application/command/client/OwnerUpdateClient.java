package dev.dmitriirussu.petclinic.web.application.command.client;

import dev.dmitriirussu.petclinic.web.application.command.model.OwnerUpdateCommand;

public interface OwnerUpdateClient {
    void update(OwnerUpdateCommand command);
}
