package dev.dmitriirussu.petclinic.web.presentation.command;

import dev.dmitriirussu.petclinic.web.application.command.usecase.OwnerCreateUseCase;
import dev.dmitriirussu.petclinic.web.application.command.usecase.OwnerUpdateUseCase;
import dev.dmitriirussu.petclinic.web.presentation.command.form.OwnerForm;
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
@RequestMapping("/owners")
public class OwnerCommandController {

    private final OwnerUpdateUseCase ownerUpdateUseCase;
    private final OwnerCreateUseCase ownerCreateUseCase;
    private final ErrorDetailExtractor errorDetailExtractor;

    @PostMapping("/new")
    public String createOwner(
            @Valid @ModelAttribute("form") OwnerForm form,
            BindingResult binding,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (binding.hasErrors()) {
            return rerenderCreate(fieldErrors(binding), null, model);
        }

        String id;
        try {
            id = ownerCreateUseCase.create(form.toCreateCommand());
        } catch (
                  HttpClientErrorException.Conflict
                | HttpClientErrorException.BadRequest
                | HttpClientErrorException.UnprocessableEntity ex
        ) {
            return rerenderCreate(Map.of(), errorDetailExtractor.extractDetail(ex), model);
        }

        redirectAttributes.addFlashAttribute("message", "Owner saved successfully");
        return "redirect:/owners/" + id;
    }

    @PostMapping("/{ownerId}/edit")
    public String updateOwner(
            @PathVariable String ownerId,
            @Valid @ModelAttribute("form") OwnerForm form,
            BindingResult binding,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (binding.hasErrors()) {
            return rerenderEdit(ownerId, fieldErrors(binding), null, model);
        }

        try {
            ownerUpdateUseCase.update(form.toUpdateCommand(ownerId));
        } catch (
                  HttpClientErrorException.Conflict
                | HttpClientErrorException.BadRequest
                | HttpClientErrorException.UnprocessableEntity ex
        ) {
            return rerenderEdit(ownerId, Map.of(), errorDetailExtractor.extractDetail(ex), model);
        }

        redirectAttributes.addFlashAttribute("message", "Owner updated successfully");

        return "redirect:/owners/" + ownerId;
    }

    private String rerenderCreate(Map<String, String> fieldErrors, String globalError, Model model) {
        model.addAttribute("errors", fieldErrors);
        model.addAttribute("error", globalError != null ? globalError : "");
        return "owner/form/owner-create-form";
    }

    private String rerenderEdit(String ownerId, Map<String, String> fieldErrors, String globalError, Model model) {
        model.addAttribute("ownerId", ownerId);
        model.addAttribute("errors", fieldErrors);
        model.addAttribute("error", globalError != null ? globalError : "");
        return "owner/form/owner-edit-form";
    }

    private static Map<String, String> fieldErrors(BindingResult binding) {
        return binding.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (a, b) -> a));
    }
}