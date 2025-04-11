package com.bigdata.pattern.decorator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/decorator")
@Tag(name = "Decorator", description = "Decorator pattern operations")
public class DecoratorController {

    private final Notifier notifier;

    public DecoratorController(Notifier basicNotifier) {
        // Composición dinámica de decoradores
        this.notifier = new LoggingNotifier(new EncryptionNotifier(basicNotifier));
    }

    @PostMapping("/notify")
    @Operation(summary = "Decorator Pattern", description = "Notify using Decorator Pattern")
    @Parameter(name = "message", description = "Message to send", required = true, example = "Hello World with decorator")
    public String notify(@RequestParam String message) {
        return notifier.send(message);
    }
}
