package dev.dmitriirussu.petclinic.resource.application.command.repository;


import dev.dmitriirussu.petclinic.resource.model.Visit;

public interface VisitCreateRepository {
    void create(Visit visit, String ownerId);
}
