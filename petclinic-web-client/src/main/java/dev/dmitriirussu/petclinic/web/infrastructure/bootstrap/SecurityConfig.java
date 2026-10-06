package dev.dmitriirussu.petclinic.web.infrastructure.bootstrap;

import dev.dmitriirussu.petclinic.web.presentation.support.CurrentAccount;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, CurrentAccount account) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(a -> a
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/index.html", "/error").permitAll()
                        .requestMatchers("/admin/**").access((authentication, context) ->
                                new AuthorizationDecision(isAdmin(authentication.get(), account)))
                        .anyRequest().authenticated())
                .oauth2Login(o -> o.defaultSuccessUrl("/home", true))
                .logout(l -> l.logoutSuccessUrl("/"));

        return http.build();
    }

    private static boolean isAdmin(Authentication authentication, CurrentAccount account) {
        return authentication != null
                && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)
                && account.isAdmin();
    }
}