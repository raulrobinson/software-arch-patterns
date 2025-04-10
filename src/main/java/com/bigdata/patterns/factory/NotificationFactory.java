package com.bigdata.patterns.factory;

import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    public Notification getNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            default -> throw new IllegalArgumentException("Tipo desconocido");
        };
    }
}
