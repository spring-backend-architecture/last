package dev.dmitriirussu.petclinic.web.application.command.client;

import dev.dmitriirussu.petclinic.web.application.command.model.OwnerCreateCommand;

public interface OwnerCreateClient {
    String create(OwnerCreateCommand command);
}
