package dev.dmitriirussu.petclinic.web.presentation.support.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class ErrorDetailExtractor {
    private final ObjectMapper objectMapper;

    public String extractDetail(HttpStatusCodeException ex) {
        String responseBody = ex.getResponseBodyAsString();
        if (responseBody == null || responseBody.isBlank()) {
            return ex.getStatusText();
        }
        try {
            String detail = objectMapper.readTree(responseBody).path("detail").asText("");
            return detail.isBlank() ? ex.getStatusText() : detail;
        } catch (Exception e) {
            return ex.getStatusText();
        }
    }
}
