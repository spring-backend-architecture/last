package dev.dmitriirussu.petclinic.web.presentation.command;

import dev.dmitriirussu.petclinic.web.application.command.usecase.VisitCreateUseCase;
import dev.dmitriirussu.petclinic.web.application.query.usecase.form.VisitCreateFormUseCase;
import dev.dmitriirussu.petclinic.web.presentation.command.form.VisitForm;
import dev.dmitriirussu.petclinic.web.presentation.support.exception.ErrorDetailExtractor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitCommandController {

    private final VisitCreateUseCase visitCreateUseCase;
    private final VisitCreateFormUseCase visitCreateFormUseCase;
    private final ErrorDetailExtractor errorDetailExtractor;

    @PostMapping("/new")
    public String createVisit(
            @RequestParam String petId,
            @RequestParam String ownerId,
            @Valid @ModelAttribute("form") VisitForm form,
            BindingResult binding,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (binding.hasErrors()) {
            return rerenderCreate(petId, fieldErrors(binding), null, model);
        }

        try {
            visitCreateUseCase.create(form.toCreateCommand(petId, ownerId));
        } catch (
                  HttpClientErrorException.Conflict
                | HttpClientErrorException.BadRequest
                | HttpClientErrorException.UnprocessableEntity ex
        ) {
            return rerenderCreate(petId, Map.of(), errorDetailExtractor.extractDetail(ex), model);
        }

        redirectAttributes.addFlashAttribute("message", "Visit added successfully");
        return "redirect:/owners/" + ownerId;
    }

    private String rerenderCreate(String petId, Map<String, String> fieldErrors, String globalError, Model model) {
        model.addAttribute("visitCreateForm", visitCreateFormUseCase.findByPetId(petId));
        model.addAttribute("errors", fieldErrors);
        model.addAttribute("error", globalError != null ? globalError : "");
        return "owner/form/visit-create-form";
    }

    private static Map<String, String> fieldErrors(BindingResult binding) {
        return binding.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (a, b) -> a));
    }
}