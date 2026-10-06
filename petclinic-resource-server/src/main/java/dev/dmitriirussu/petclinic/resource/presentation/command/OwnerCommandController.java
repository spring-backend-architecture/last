package dev.dmitriirussu.petclinic.resource.presentation.command;

import dev.dmitriirussu.petclinic.resource.application.command.model.OwnerCreateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.model.OwnerUpdateCommand;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.OwnerCreateUseCase;
import dev.dmitriirussu.petclinic.resource.application.command.usecase.OwnerUpdateUseCase;
import dev.dmitriirussu.petclinic.resource.presentation.support.request.OwnerCreateOrEditRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerCommandController {
    private final OwnerCreateUseCase createOwnerUseCase;
    private final OwnerUpdateUseCase updateOwnerUseCase;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOwner(@Valid @RequestBody OwnerCreateOrEditRequest request) {
        return createOwnerUseCase.createOwner(
                new OwnerCreateCommand(
                        request.firstName(),
                        request.lastName(),
                        request.street(),
                        request.city(),
                        request.telephone()
                )
        );
    }

    @PostMapping("/{ownerId}/edit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(
            @PathVariable String ownerId,
            @Valid @RequestBody OwnerCreateOrEditRequest request
    ) {
        updateOwnerUseCase.updateOwner(
                new OwnerUpdateCommand(
                        ownerId,
                        request.firstName(),
                        request.lastName(),
                        request.street(),
                        request.city(),
                        request.telephone()
                )
        );
    }
}