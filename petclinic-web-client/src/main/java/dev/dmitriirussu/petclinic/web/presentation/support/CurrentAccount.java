package dev.dmitriirussu.petclinic.web.presentation.support;

import dev.dmitriirussu.petclinic.web.presentation.HomeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@RequiredArgsConstructor
public class CurrentAccount {

    private final RestClient restClient;
    private HomeResponse data;

    public HomeResponse get() {
        if (data == null) {
            data = restClient.get().uri("/home").retrieve().body(HomeResponse.class);
        }
        return data;
    }

    public boolean isAdmin() { return "ADMIN".equals(get().role()); }
}
