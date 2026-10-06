package dev.dmitriirussu.petclinic.web.presentation;

import dev.dmitriirussu.petclinic.web.presentation.support.CurrentAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
class HomeController {

    private final CurrentAccount account;

    @GetMapping("/home")
    String home() {
        return account.isAdmin()
                ? "redirect:/admin/owners/find"
                : "redirect:/owners/" + account.get().accountId();
    }
}
