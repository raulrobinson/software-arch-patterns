package com.bigdata.patterns.singleton;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/singleton")
@Tag(name = "Singleton", description = "Singleton operations")
public class SingletonController {

    private final EmailService emailService;

    public SingletonController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/notify")
    @Operation(summary = "Singleton Pattern", description = "Notify user using Singleton Pattern")
    @Parameter(name = "email", description = "Email user", required = true, example = "john.doe@email.com")
    public void notifyUser(@RequestParam String email) {
        emailService.send(email, "Hola desde Spring!");
    }
}
