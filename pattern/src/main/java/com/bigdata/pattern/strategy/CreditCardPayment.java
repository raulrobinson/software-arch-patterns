package com.bigdata.pattern.strategy;

import org.springframework.stereotype.Component;

@Component("creditcard")
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Pagando con tarjeta: " + amount);
    }
}
