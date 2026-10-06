package dev.dmitriirussu.petclinic.resource.infrastructure.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetEditForm;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.SqlLoader;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.ViewExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
class PetEditFormRepositoryImpl implements PetEditFormRepository {

    private final JdbcClient jdbc;
    private static final String PET_EDIT_FORM_SQL =
            SqlLoader.load("sql/query/form/pet-edit-form.sql");

    @Override
    @Cacheable(cacheNames = "petEditForm", key = "#petId")
    public PetEditForm findByPetId(String petId) {
        return jdbc.sql(PET_EDIT_FORM_SQL)
                .param("id", petId)
                .query(ViewExtractor::getPetEditForm)
                .optional()
                .orElseThrow(() -> new NoSuchElementException("Pet not found: " + petId));
    }
}