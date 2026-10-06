package dev.dmitriirussu.petclinic.web.presentation.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.VisitCreateFormClient;
import dev.dmitriirussu.petclinic.web.application.query.view.form.VisitCreateForm;
import dev.dmitriirussu.petclinic.web.presentation.command.form.VisitForm;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitFormController {

    private final VisitCreateFormClient visitCreateFormClient;

    @GetMapping("/new")
    public String findByPetId(@RequestParam String petId, Model model) {

        VisitCreateForm visitCreateForm = visitCreateFormClient.findByPetId(petId);

        model.addAttribute("errors", Map.of());
        model.addAttribute("form", new VisitForm());
        model.addAttribute("visitCreateForm", visitCreateForm);

        return "owner/form/visit-create-form";
    }
}
