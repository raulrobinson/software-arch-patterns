package com.bigdata.pattern.strategy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/strategy")
@Tag(name = "Strategy", description = "Strategy operations")
public class StrategyController {

    private final PaymentService service;

    public StrategyController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/pay")
    @Operation(summary = "Strategy Pattern", description = "Pay using Strategy Pattern")
    @Parameter(name = "method", description = "Payment method", required = true, example = "credit_card")
    @Parameter(name = "amount", description = "Amount to pay", required = true, example = "100.25")
    public void pay(@RequestParam String method,
                    @RequestParam double amount) {
        service.pay(method, amount);
    }
}
