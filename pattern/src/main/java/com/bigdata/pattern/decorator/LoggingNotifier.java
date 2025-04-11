package com.bigdata.pattern.decorator;

public class LoggingNotifier extends NotifierDecorator {

    public LoggingNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public String send(String message) {
        System.out.println("[LOG] Enviando mensaje: " + message);
        return notifier.send(message);
    }
}
