package dev.dmitriirussu.petclinic.resource.presentation.checksecurity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class WhoAmIController {

    @GetMapping("/api/whoami")
    public Map<String, Object> whoAmI(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "subject", jwt.getSubject(),
                "scope", Objects.requireNonNullElse(jwt.getClaimAsStringList("scope"), List.of()),
                "issuedAt", jwt.getIssuedAt().toString(),
                "expiresAt", jwt.getExpiresAt().toString(),
                "tokenId", jwt.getId()
        );
    }
}
