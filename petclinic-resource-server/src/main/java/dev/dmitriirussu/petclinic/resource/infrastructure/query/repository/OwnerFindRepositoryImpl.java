package dev.dmitriirussu.petclinic.resource.infrastructure.query.repository;

import dev.dmitriirussu.petclinic.resource.application.query.repository.OwnerFindRepository;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerView;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.SqlLoader;
import dev.dmitriirussu.petclinic.resource.infrastructure.query.support.ViewExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
class OwnerFindRepositoryImpl implements OwnerFindRepository {
    private final JdbcClient jdbc;
    private static final String OWNER_DETAILS_SQL =
            SqlLoader.load("sql/query/find-owner.sql");

    @Override
    @Cacheable(cacheNames = "ownerDetails", key = "#id")
    public OwnerView findById(String id) {
        return jdbc.sql(OWNER_DETAILS_SQL)
                .param("id", id)
                .query(ViewExtractor::getOwnerDetails)
                .optional()
                .orElseThrow(() -> new NoSuchElementException("Owner not found"));
    }
}