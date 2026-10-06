package dev.dmitriirussu.petclinic.resource.presentation.query;

import dev.dmitriirussu.petclinic.resource.application.query.OwnerSearchCriteria;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerFindUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.usecase.OwnerSearchUseCase;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerListView;
import dev.dmitriirussu.petclinic.resource.application.query.view.OwnerView;
import dev.dmitriirussu.petclinic.resource.presentation.support.pagination.PageQuery;
import dev.dmitriirussu.petclinic.resource.presentation.support.pagination.PageResult;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerQueryController {
    private static final int PAGE_SIZE = 5;

    private final OwnerFindUseCase ownerFindUseCase;
    private final OwnerSearchUseCase ownerSearchUseCase;

    @GetMapping("/search")
    public PageResult<OwnerListView> search(
            @RequestParam(required = false) String lastName,
            @RequestParam(defaultValue = "1") @Min(1) int page
    ) {
        var criteria = new OwnerSearchCriteria(lastName);
        var query = new PageQuery(page, PAGE_SIZE);

        return ownerSearchUseCase.search(criteria, query);
    }

    @GetMapping("/{id}")
    public OwnerView findById(@PathVariable String id) {
        return ownerFindUseCase.findById(id);
    }
}