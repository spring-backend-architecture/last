package dev.dmitriirussu.petclinic.resource.presentation.command;

import dev.dmitriirussu.petclinic.resource.application.command.model.VisitCreateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.VisitCreateUseCase;
import dev.dmitriirussu.petclinic.resource.presentation.support.request.VisitCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitCommandController {
    private final VisitCreateUseCase createVisit;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVisit(
            @RequestParam String petId,
            @RequestParam String ownerId,
            @Valid @RequestBody VisitCreateRequest request
            ) {
        createVisit.create(
                new VisitCreateCommand(
                        request.visitDate(),
                        request.description(),
                        petId,
                        ownerId
                )
        );
    }
}