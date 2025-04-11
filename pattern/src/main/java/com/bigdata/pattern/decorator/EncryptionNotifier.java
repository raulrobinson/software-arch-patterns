package com.bigdata.pattern.decorator;

public class EncryptionNotifier extends NotifierDecorator {

    public EncryptionNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public String send(String message) {
        String encrypted = "[encrypted]" + message + "[/encrypted]";
        return notifier.send(encrypted);
    }
}
