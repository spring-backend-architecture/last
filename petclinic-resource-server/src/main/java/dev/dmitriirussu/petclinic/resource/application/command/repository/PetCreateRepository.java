package dev.dmitriirussu.petclinic.resource.application.command.repository;


import dev.dmitriirussu.petclinic.resource.model.Pet;

public interface PetCreateRepository {
    void create(Pet pet);
}
