package com.bigdata.pattern.factory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/factory")
@Tag(name = "Factory", description = "Factory operations")
public class FactoryController {

    private final NotificationFactory factory;

    public FactoryController(NotificationFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/send")
    @Operation(summary = "Factory Pattern", description = "Send notification using Factory Pattern")
    @Parameter(name = "type", description = "Notification type", required = true, example = "email")
    @Parameter(name = "msg", description = "Message to send", required = true, example = "Hello World from factory")
    public void send(@RequestParam String type,
                     @RequestParam String msg) {
        Notification notification = factory.getNotification(type);
        notification.send(msg);
    }
}
