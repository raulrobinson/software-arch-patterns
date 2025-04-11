package com.bigdata.pattern.template;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification extends NotificationTemplate {

    @Override
    protected void validateRecipient(String recipient) {
        System.out.println("📱 Validando número de teléfono: " + recipient);
    }

    @Override
    protected void prepareMessage(String message) {
        System.out.println("📱 Ajustando mensaje SMS: " + message);
    }

    @Override
    protected void send(String recipient, String message) {
        System.out.println("📱 Enviando SMS a " + recipient + " con mensaje: " + message);
    }
}
