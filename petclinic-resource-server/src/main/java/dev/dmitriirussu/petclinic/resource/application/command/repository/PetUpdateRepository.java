package dev.dmitriirussu.petclinic.resource.application.command.repository;


import dev.dmitriirussu.petclinic.resource.model.Pet;

public interface PetUpdateRepository {
    void update(Pet pet);
}
