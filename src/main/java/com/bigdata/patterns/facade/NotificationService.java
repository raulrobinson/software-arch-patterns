package com.bigdata.patterns.facade;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(String userId, String message) {
        System.out.println("Notificando a " + userId + ": " + message);
    }
}
