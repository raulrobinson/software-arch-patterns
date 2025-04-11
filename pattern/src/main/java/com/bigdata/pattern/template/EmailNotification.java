package com.bigdata.pattern.template;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification extends NotificationTemplate {

    @Override
    protected void validateRecipient(String recipient) {
        System.out.println("📧 Validando dirección de correo: " + recipient);
    }

    @Override
    protected void prepareMessage(String message) {
        System.out.println("📧 Preparando contenido HTML: " + message);
    }

    @Override
    protected void send(String recipient, String message) {
        System.out.println("📧 Enviando correo a " + recipient + " con mensaje: " + message);
    }
}
