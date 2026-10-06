package dev.dmitriirussu.petclinic.web.infrastructure.command;

import dev.dmitriirussu.petclinic.web.application.command.client.PetUpdateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.PetUpdateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class PetUpdateClientImpl implements PetUpdateClient {
    private final RestClient restClient;

    @Override
    public void update(PetUpdateCommand command) {
        restClient.post()
                .uri("/pets/{petId}/edit", command.petId())
                .contentType(MediaType.APPLICATION_JSON)
                .body(command)
                .retrieve()
                .body(String.class);
    }
}
