package com.bigdata.patterns.adapter;

// Clase de una librería externa, no implementa PaymentProcessor
public class StripePayment {
    public String makeStripePayment(double amountInUSD) {
        return "Pagado con Stripe: $" + amountInUSD;
    }
}