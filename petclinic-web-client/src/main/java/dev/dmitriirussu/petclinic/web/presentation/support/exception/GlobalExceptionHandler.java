package dev.dmitriirussu.petclinic.web.presentation.support.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@ControllerAdvice(basePackages = "dev.dmitriirussu.petclinic.web.presentation")
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public String handleNotFound(HttpClientErrorException.NotFound ex, Model model) {
        return renderSearchWithError(ex.getStatusText(), model);
    }

    @ExceptionHandler(Exception.class)
    public String handleUnexpected(Exception ex, Model model) {
        log.error("Unexpected exception in presentation layer", ex);
        return renderSearchWithError("Something went wrong. Please try again.", model);
    }

    private String renderSearchWithError(String error, Model model) {
        model.addAttribute("error", error);
        return "owner/form/main-page-search";
    }
}
