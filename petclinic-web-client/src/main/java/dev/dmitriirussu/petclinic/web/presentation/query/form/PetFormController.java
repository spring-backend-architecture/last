package dev.dmitriirussu.petclinic.web.presentation.query.form;

import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetCreateForm;
import dev.dmitriirussu.petclinic.web.application.query.view.form.PetEditForm;
import dev.dmitriirussu.petclinic.web.presentation.command.form.PetForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetFormController {

    private final PetEditFormUseCase petEditFormUseCase;
    private final PetCreateFormUseCase petCreateFormUseCase;

    @GetMapping("/new")
    public String findByOwnerId(@RequestParam String ownerId, Model model) {

        PetCreateForm petCreateForm = petCreateFormUseCase.findByOwnerId(ownerId);

        PetForm form = new PetForm();
        form.setOwnerId(ownerId);

        model.addAttribute("form", form);
        model.addAttribute("errors", Map.of());
        model.addAttribute("petCreateForm", petCreateForm);

        return "owner/form/pet-create-form";
    }

    @GetMapping("/{petId}/edit")
    public String findByPetId(@PathVariable String petId, Model model) {

        PetEditForm petEditForm = petEditFormUseCase.findByPetId(petId);

        model.addAttribute("petEditForm", petEditForm);
        model.addAttribute("errors", Map.<String, String>of());
        model.addAttribute("form", PetForm.prefilledFrom(petEditForm));

        return "owner/form/pet-edit-form";
    }
}