package dev.dmitriirussu.petclinic.resource.application.command.repository;

import dev.dmitriirussu.petclinic.resource.model.Owner;

public interface OwnerCreateRepository {
    void create(Owner owner);
}
