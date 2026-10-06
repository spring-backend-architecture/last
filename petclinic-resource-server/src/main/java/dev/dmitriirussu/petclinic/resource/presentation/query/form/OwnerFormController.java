package dev.dmitriirussu.petclinic.resource.presentation.query.form;

import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.OwnerEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.OwnerEditForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerFormController {
    private final OwnerEditFormUseCase ownerEditFormUseCase;

    @GetMapping("/{ownerId}/edit")
    public OwnerEditForm findByOwnerId(@PathVariable String ownerId) {
        return ownerEditFormUseCase.findByOwnerId(ownerId);
    }
}
