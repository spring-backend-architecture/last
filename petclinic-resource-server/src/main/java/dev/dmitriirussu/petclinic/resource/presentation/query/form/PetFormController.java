package dev.dmitriirussu.petclinic.resource.presentation.query.form;

import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetCreateForm;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.PetEditForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetFormController {
    private final PetCreateFormUseCase petCreateFormUseCase;
    private final PetEditFormUseCase petEditFormUseCase;

    @GetMapping("/new")
    public PetCreateForm findByOwnerId(@RequestParam String ownerId) {
        return petCreateFormUseCase.findByOwnerId(ownerId);
    }

    @GetMapping("/{petId}/edit")
    public PetEditForm findByPetId(@PathVariable String petId) {
        return petEditFormUseCase.findByPetId(petId);
    }
}