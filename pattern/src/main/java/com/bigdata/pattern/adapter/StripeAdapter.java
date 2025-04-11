package com.bigdata.pattern.adapter;

import org.springframework.stereotype.Component;

@Component
public class StripeAdapter implements PaymentProcessor {

    private final StripePayment stripePayment = new StripePayment();

    @Override
    public String processPayment(double amount) {
        // Adaptamos la llamada a la interfaz esperada
        return stripePayment.makeStripePayment(amount);
    }
}
