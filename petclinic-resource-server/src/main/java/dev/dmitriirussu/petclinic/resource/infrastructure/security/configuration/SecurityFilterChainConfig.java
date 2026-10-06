package dev.dmitriirussu.petclinic.resource.infrastructure.security.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfig {
    private final Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter;

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            AccessDeniedHandler accessDeniedHandler,
            AuthenticationEntryPoint authenticationEntryPoint
    ) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/api/items/all").hasRole("ADMIN")
                        //.requestMatchers("/api/items").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter))
                        .authenticationEntryPoint(authenticationEntryPoint)
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler(accessDeniedHandler)
                );

        return http.build();
    }
}
