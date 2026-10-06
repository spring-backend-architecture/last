package dev.dmitriirussu.petclinic.resource.infrastructure.query.repository.form;

import dev.dmitriirussu.petclinic.resource.application.query.repository.form.OwnerEditFormRepository;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.OwnerEditForm;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.SqlLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
class OwnerEditFormRepositoryImpl implements OwnerEditFormRepository {

    private final JdbcClient jdbc;
    private static final String OWNER_EDIT_FORM_SQL =
            SqlLoader.load("sql/query/form/owner-edit-form.sql");

    @Override
    @Cacheable(cacheNames = "ownerEditForm", key = "#ownerId")
    public OwnerEditForm findByOwnerId(String ownerId) {
        return jdbc.sql(OWNER_EDIT_FORM_SQL)
                .param("ownerId", ownerId)
                .query(OwnerEditForm.class)
                .optional()
                .orElseThrow(() -> new NoSuchElementException("Owner not found: " + ownerId));
    }
}
