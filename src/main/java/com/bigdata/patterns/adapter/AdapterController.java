package com.bigdata.patterns.adapter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/adapter")
@Tag(name = "Adapter", description = "Adapter operations")
public class AdapterController {

    private final PaymentProcessor processor;

    public AdapterController(PaymentProcessor processor) {
        this.processor = processor;
    }

    @PostMapping("/pay")
    @Operation(summary = "Adapter Pattern", description = "Pay using Adapter Pattern")
    @Parameter(name = "amount", description = "Amount to pay", required = true, example = "100.25")
    public String pay(@RequestParam double amount) {
        return processor.processPayment(amount);
    }
}
