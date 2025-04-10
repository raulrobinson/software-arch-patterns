package com.bigdata.patterns.decorator;

import org.springframework.stereotype.Component;

@Component("basicNotifier")
public class BasicNotifier implements Notifier {
    @Override
    public String send(String message) {
        return "Notificación enviada: " + message;
    }
}
