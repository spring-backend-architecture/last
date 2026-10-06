package dev.dmitriirussu.petclinic.web.infrastructure.command;

import dev.dmitriirussu.petclinic.web.application.command.client.PetCreateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.PetCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class PetCreateClientImpl implements PetCreateClient {
    private final RestClient restClient;

    @Override
    public void create(PetCreateCommand command) {
        restClient.post()
                .uri("/pets/new")
                .contentType(MediaType.APPLICATION_JSON)
                .body(command)
                .retrieve()
                .body(String.class);
    }
}
