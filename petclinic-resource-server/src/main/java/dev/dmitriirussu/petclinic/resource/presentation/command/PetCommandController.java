package dev.dmitriirussu.petclinic.resource.presentation.command;

import dev.dmitriirussu.petclinic.resource.application.command.model.PetCreateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.model.PetUpdateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.PetCreateUseCase;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.PetUpdateUseCase;
import dev.dmitriirussu.petclinic.resource.presentation.support.request.PetCreateOrEditRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetCommandController {
    private final PetCreateUseCase createPetUseCase;
    private final PetUpdateUseCase updatePetUseCase;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPet(@Valid @RequestBody PetCreateOrEditRequest request) {
        createPetUseCase.createPet(
                new PetCreateCommand(
                        request.name(),
                        request.birthDate(),
                        request.type(),
                        request.ownerId()
                )
        );
    }

    @PostMapping("/{petId}/edit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePet(
            @PathVariable String petId,
            @Valid @RequestBody PetCreateOrEditRequest request
    ) {
        updatePetUseCase.updatePet(
                new PetUpdateCommand(
                        petId,
                        request.name(),
                        request.birthDate(),
                        request.type(),
                        request.ownerId()
                )
        );
    }
}