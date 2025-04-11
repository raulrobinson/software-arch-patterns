package com.bigdata.pattern.factory;

public class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
