package dev.dmitriirussu.petclinic.resource.presentation.security;

import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.resource.infrastructure.security.identitysupport.IdentityLookup;
import dev.dmitriirussu.petclinic.resource.infrastructure.security.identitysupport.IdentityProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final OwnerFindUseCase ownerFindUseCase;

    @GetMapping("/home")
    HomeResponse home(Authentication auth) {
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            return new HomeResponse("ADMIN", null);
        return new HomeResponse("USER", auth.getName()); // name = accountId
    }
}
