package com.bigdata.pattern.template;

public abstract class NotificationTemplate {

    public final void sendNotification(String recipient, String message) {
        validateRecipient(recipient);
        prepareMessage(message);
        send(recipient, message);
        log(recipient);
    }

    protected abstract void validateRecipient(String recipient);
    protected abstract void prepareMessage(String message);
    protected abstract void send(String recipient, String message);

    protected void log(String recipient) {
        System.out.println("✅ Notificación enviada a " + recipient);
    }
}
