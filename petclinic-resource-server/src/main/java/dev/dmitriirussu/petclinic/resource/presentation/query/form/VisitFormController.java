package dev.dmitriirussu.petclinic.resource.presentation.query.form;

import dev.dmitriirussu.petclinic.resource.application.query.usecase.form.VisitCreateFormUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.form.VisitCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitFormController {
    private final VisitCreateFormUseCase visitCreateFormUseCase;

    @GetMapping("/new")
    public VisitCreateForm findByPetId(@RequestParam String petId) {
        return visitCreateFormUseCase.findByPetId(petId);
    }
}