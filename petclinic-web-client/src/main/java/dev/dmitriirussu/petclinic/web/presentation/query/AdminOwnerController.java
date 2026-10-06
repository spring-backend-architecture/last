package dev.dmitriirussu.petclinic.web.presentation.query;

import dev.dmitriirussu.petclinic.web.application.query.PageResult;
import dev.dmitriirussu.petclinic.web.application.query.client.OwnerSearchClient;
import dev.dmitriirussu.petclinic.web.application.query.view.OwnerListView;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/owners")
class AdminOwnerController {

    private static final String SEARCH_FORM = "owner/form/main-page-search";

    private final OwnerSearchClient ownerSearchClient;

    @GetMapping("/find")
    String form() {
        return SEARCH_FORM;
    }

    @GetMapping
    String search(
            @RequestParam(required = false) String lastName,
            @RequestParam(defaultValue = "1") @Min(1) int page,
            Model model
    ) {
        String query = lastName == null ? "" : lastName.strip();
        PageResult<OwnerListView> result = ownerSearchClient.search(query, page);

        model.addAttribute("lastName", query);

        if (result.total() == 0) {
            model.addAttribute("error", "No owners found");
            return SEARCH_FORM;
        }
        if (result.total() == 1) {
            return "redirect:/owners/" + result.content().get(0).id();
        }

        model.addAttribute("result", result);
        model.addAttribute("currentPage", page);

        return "owner/result/owners-list";
    }
}