package dev.dmitriirussu.petclinic.web.presentation.query.form;

import dev.dmitriirussu.petclinic.web.application.query.client.form.OwnerEditFormClient;
import dev.dmitriirussu.petclinic.web.application.query.view.form.OwnerEditForm;
import dev.dmitriirussu.petclinic.web.presentation.command.form.OwnerForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerFormController {

    private final OwnerEditFormClient ownerEditFormClient;

    @GetMapping
    public String showOwnerSearchForm(Model model) {

        model.addAttribute("error", "");
        model.addAttribute("message", "");

        return "owner/form/main-page-search";
    }

    @GetMapping("/new")
    public String showOwnerCreateForm(Model model) {

        model.addAttribute("form", new OwnerForm());
        model.addAttribute("errors", Map.<String, String>of());

        return "owner/form/owner-create-form";
    }

    @GetMapping("/{ownerId}/edit")
    public String showOwnerEditForm(@PathVariable String ownerId, Model model) {

        OwnerEditForm ownerEditForm = ownerEditFormClient.findByOwnerId(ownerId);

        model.addAttribute("ownerId", ownerId);
        model.addAttribute("errors", Map.<String, String>of());
        model.addAttribute("form", OwnerForm.prefilledFrom(ownerEditForm));

        return "owner/form/owner-edit-form";
    }
}
