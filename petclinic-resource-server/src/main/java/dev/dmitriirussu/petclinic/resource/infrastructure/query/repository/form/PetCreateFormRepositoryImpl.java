package dev.dmitriirussu.petclinic.resource.infrastructure.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.PetCreateFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetCreateForm;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.SqlLoader;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.ViewExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
class PetCreateFormRepositoryImpl implements PetCreateFormRepository {

    private final JdbcClient jdbc;
    private static final String SQL = SqlLoader.load(
            "sql/query/form/pet-create-form.sql"
    );

    @Override
    @Cacheable(cacheNames = "petCreateForm", key = "#ownerId")
    public PetCreateForm findByOwnerId(String ownerId) {
        return jdbc.sql(SQL)
                .param("ownerId", ownerId)
                .query(ViewExtractor::getPetCreateForm)
                .optional()
                .orElseThrow(() -> new NoSuchElementException("Owner not found: " + ownerId));
    }
}