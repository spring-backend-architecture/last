package dev.dmitriirussu.petclinic.web.infrastructure.command;

import dev.dmitriirussu.petclinic.web.application.command.client.VisitCreateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.VisitCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
final class VisitCreateClientImpl implements VisitCreateClient {

    private final RestClient restClient;

    @Override
    public void create(VisitCreateCommand command) {
        restClient.post()
                .uri("/visits/new?petId={petId}&ownerId={ownerId}", command.petId(), command.ownerId())
                .contentType(MediaType.APPLICATION_JSON)
                .body(command)
                .retrieve()
                .body(String.class);
    }
}
