package com.bigdata.patterns.singleton;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void send(String to, String message) {
        System.out.println("Enviando a " + to + ": " + message);
    }
}
