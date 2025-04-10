package com.bigdata.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedListener {

    @EventListener
    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println("👂 Listener recibido evento de usuario: " + event.getUser().getName());
        // Aquí puedes enviar email, loggear, etc.
    }
}
