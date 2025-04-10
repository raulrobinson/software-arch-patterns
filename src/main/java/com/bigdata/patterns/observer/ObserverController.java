package com.bigdata.patterns.observer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/observers")
@Tag(name = "Observer", description = "Observer operations")
public class ObserverController {

    private final ApplicationEventPublisher eventPublisher;

    public ObserverController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/create-user")
    @Operation(summary = "Observer Pattern", description = "Create user and publish event")
    public String createUser(@RequestBody User user) {
        // Simula guardar usuario
        System.out.println("Usuario creado: " + user.getName());

        // Publicar evento
        UserCreatedEvent event = new UserCreatedEvent(this, user);
        eventPublisher.publishEvent(event);

        return "Usuario creado y evento publicado";
    }
}
