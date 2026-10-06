package dev.dmitriirussu.petclinic.web.infrastructure.command;

import dev.dmitriirussu.petclinic.web.application.command.client.OwnerUpdateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.OwnerUpdateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class OwnerUpdateClientImpl implements OwnerUpdateClient {

    private final RestClient restClient;

    @Override
    public void update(OwnerUpdateCommand command) {
        restClient.post()
                .uri("/owners/{ownerId}/edit", command.ownerId())
                .contentType(MediaType.APPLICATION_JSON)
                .body(command)
                .retrieve()
                .body(String.class);
    }
}

