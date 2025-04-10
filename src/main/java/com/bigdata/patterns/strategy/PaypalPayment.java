package com.bigdata.patterns.strategy;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Pagando con PayPal: " + amount);
    }
}
