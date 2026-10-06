package dev.dmitriirussu.petclinic.web.presentation.query;

import dev.dmitriirussu.petclinic.web.application.query.client.OwnerFindClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners")
class OwnerQueryController {

    private final OwnerFindClient ownerFindClient;

    @GetMapping("/{id}")
    String details(@PathVariable UUID id, Model model) {
        model.addAttribute("owner", ownerFindClient.findById(id.toString()));
        return "owner/result/owner-details";
    }
}