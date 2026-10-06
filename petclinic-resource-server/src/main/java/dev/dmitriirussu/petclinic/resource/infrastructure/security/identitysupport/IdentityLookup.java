package dev.dmitriirussu.petclinic.resource.infrastructure.security.identitysupport;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IdentityLookup {
    private final JdbcClient jdbc;

    public IdentityProjection findByUsername(String username) {
        var sql = """
                select a.id as account_id, r.role as role
                from accounts a
                join account_roles r on r.account_id = a.id
                where a.username = :username
                """;
        return jdbc.sql(sql)
                .param("username", username)
                .query(IdentityProjection.class)
                .single();
    }
}
