package dev.dmitriirussu.petclinic.web.infrastructure.command;

import dev.dmitriirussu.petclinic.web.application.command.client.OwnerCreateClient;
import dev.dmitriirussu.petclinic.web.application.command.model.OwnerCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

/**
 * Сериализует {@link OwnerCreateCommand} напрямую, без отдельного DTO вида
 * OwnerApiPayload.
 * <p>
 * Осознанное решение, а не недосмотр: поля команды и тело запроса
 * ресурсного сервера сейчас совпадают один в один (имена, состав, формат).
 * Отдельный payload-класс в такой ситуации был бы дублем без защитной
 * функции — command и так наш собственный тип, ему нечего скрывать
 * от сериализатора.
 * <p>
 * Завести OwnerApiPayload, как только появится реальное расхождение:
 *   - другое имя поля на стороне ресурсного сервера (например, phone вместо telephone);
 *   - нужен нестандартный формат сериализации (@JsonProperty, кастомный сериализатор
 *     и т.п.), который не должен просачиваться в application-слой;
 *   - в теле запроса нужны поля, которых нет в команде (версия API, служебные метаданные);
 *   - один и тот же command используется для вызовов с разными payload'ами.
 *
 * @see dev.dmitriirussu.petclinic.web.application.command.model.OwnerCreateCommand
 */

@RequiredArgsConstructor
final class OwnerCreateClientImpl implements OwnerCreateClient {

    private final RestClient restClient;

    @Override
    public String create(OwnerCreateCommand command) {
        return restClient.post()
                .uri("/owners/new")
                .contentType(MediaType.APPLICATION_JSON)
                .body(command)
                .retrieve()
                .body(String.class);
    }
}
