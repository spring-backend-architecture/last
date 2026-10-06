package dev.dmitriirussu.petclinic.resource.infrastructure.security.configuration;

import dev.dmitriirussu.petclinic.resource.infrastructure.security.identitysupport.IdentityLookup;
import dev.dmitriirussu.petclinic.resource.infrastructure.security.identitysupport.IdentityProjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JwtAuthConverterConfig {
    private final IdentityLookup identityLookup;

    @Bean
    Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
        return jwt -> {

            IdentityProjection projection
                    = identityLookup.findByUsername(jwt.getSubject());

            return new JwtAuthenticationToken(
                    jwt,
                    List.of(new SimpleGrantedAuthority("ROLE_" + projection.role())),
                    projection.accountId().toString()
            );
        };
    }
}
