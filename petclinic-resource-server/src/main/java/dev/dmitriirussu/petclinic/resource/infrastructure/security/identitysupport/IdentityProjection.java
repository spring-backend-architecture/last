package dev.dmitriirussu.petclinic.resource.infrastructure.security.identitysupport;

import java.util.UUID;

public record IdentityProjection(
        UUID accountId,
        String role
) {}
