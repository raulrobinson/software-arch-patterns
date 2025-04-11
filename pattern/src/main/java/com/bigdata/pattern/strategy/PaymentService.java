package com.bigdata.pattern.strategy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentService(List<PaymentStrategy> strategyList) {
        strategies = new HashMap<>();
        for (PaymentStrategy strategy : strategyList) {
            strategies.put(strategy.getClass().getAnnotation(Component.class).value(), strategy);
        }
    }

    public void pay(String type, double amount) {
        strategies.get(type).pay(amount);
    }
}

