package dev.dmitriirussu.petclinic.web.application.query;

import java.util.List;

public record PageResult<T>(List<T> content, int page, int size, long total) {
    public int totalPages() {
        return (int) Math.ceil((double) total / size);
    }

    public boolean isEmpty() { return content.isEmpty(); }
}
