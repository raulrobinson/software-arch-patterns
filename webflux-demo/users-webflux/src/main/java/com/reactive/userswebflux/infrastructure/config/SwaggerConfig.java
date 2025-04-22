package com.reactive.userswebflux.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Usuarios",
                description = "API para gestionar usuarios de manera avanzada",
                version = "2.0.0",
                contact = @Contact(
                        name = "Raul Bolivar Navas",
                        email = "rasysbox@hotmail.com",
                        url = "https://www.rasysbox.com"
                ),
                license = @License(
                        name = "Licencia MIT",
                        url = "https://opensource.org/licenses/MIT"
                ),
                termsOfService = "https://www.rasysbox.com/terms-of-service"
        )
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user-api")
                .pathsToMatch("/users/**") // Puedes especificar el grupo de rutas que quieres documentar
                .build();
    }

}
