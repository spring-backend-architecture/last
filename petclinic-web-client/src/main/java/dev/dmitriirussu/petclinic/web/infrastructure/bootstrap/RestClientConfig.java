package dev.dmitriirussu.petclinic.web.infrastructure.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient resourceServerClient(
            @Value(
                    "${resource-server.base-url}") String baseUrl,
                    OAuth2AuthorizedClientManager manager
    ) {

        var interceptor = new OAuth2ClientHttpRequestInterceptor(manager);
        interceptor.setClientRegistrationIdResolver(request -> "login-client");

        return RestClient.builder()
                .baseUrl(baseUrl)
                .requestInterceptor(interceptor)
                .build();
    }
}