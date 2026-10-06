package dev.dmitriirussu.petclinic.web.presentation.command;

import dev.dmitriirussu.petclinic.web.application.command.usecase.PetCreateUseCase;
import dev.dmitriirussu.petclinic.web.application.command.usecase.PetUpdateUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.PetEditFormUseCase;
import dev.dmitriirussu.petclinic.web.presentation.command.form.PetForm;
import dev.dmitriirussu.petclinic.web.presentation.support.exception.ErrorDetailExtractor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetCommandController {

    private final PetCreateUseCase petCreateUseCase;
    private final PetUpdateUseCase petUpdateUseCase;
    private final PetCreateFormUseCase petCreateFormUseCase;
    private final PetEditFormUseCase petEditFormUseCase;
    private final ErrorDetailExtractor errorDetailExtractor;

    @PostMapping("/new")
    public String createPet(
            @Valid @ModelAttribute("form") PetForm form,
            BindingResult binding,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (binding.hasErrors()) {
            return rerenderCreate(form, fieldErrors(binding), null, model);
        }
        try {
            petCreateUseCase.create(form.toCreateCommand());
        } catch (
                  HttpClientErrorException.Conflict
                | HttpClientErrorException.BadRequest
                | HttpClientErrorException.UnprocessableEntity ex
        ) {
            return rerenderCreate(form, Map.of(), errorDetailExtractor.extractDetail(ex), model);
        }
        redirectAttributes.addFlashAttribute("message", "Pet saved successfully");
        return "redirect:/owners/" + form.getOwnerId();
    }

    @PostMapping("/{petId}/edit")
    public String updatePet(
            @PathVariable String petId,
            @Valid @ModelAttribute("form") PetForm form,
            BindingResult binding,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (binding.hasErrors()) {
            return rerenderEdit(petId, fieldErrors(binding), null, model);
        }
        try {
            petUpdateUseCase.update(form.toUpdateCommand(petId));
        } catch (
                  HttpClientErrorException.Conflict
                | HttpClientErrorException.BadRequest
                | HttpClientErrorException.UnprocessableEntity ex
        ) {
            return rerenderEdit(petId, Map.of(), errorDetailExtractor.extractDetail(ex), model);
        }

        redirectAttributes.addFlashAttribute("message", "Pet updated successfully");

        return "redirect:/owners/" + form.getOwnerId();
    }

    private String rerenderCreate(PetForm form, Map<String, String> fieldErrors, String globalError, Model model) {
        model.addAttribute("petCreateForm", petCreateFormUseCase.findByOwnerId(form.getOwnerId()));
        model.addAttribute("errors", fieldErrors);
        model.addAttribute("error", globalError != null ? globalError : "");
        return "owner/form/pet-create-form";
    }

    private String rerenderEdit(String petId, Map<String, String> fieldErrors, String globalError, Model model) {
        model.addAttribute("petEditForm", petEditFormUseCase.findByPetId(petId));
        model.addAttribute("errors", fieldErrors);
        model.addAttribute("error", globalError != null ? globalError : "");
        return "owner/form/pet-edit-form";
    }

    private static Map<String, String> fieldErrors(BindingResult binding) {
        return binding.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (a, b) -> a));
    }
}