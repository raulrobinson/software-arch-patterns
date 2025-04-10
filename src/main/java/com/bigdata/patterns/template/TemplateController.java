package com.bigdata.patterns.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/template")
@Tag(name = "Template Method Pattern", description = "Template Method Pattern")
public class TemplateController {

    private final TemplateNotificationService templateNotificationService;

    public TemplateController(TemplateNotificationService templateNotificationService) {
        this.templateNotificationService = templateNotificationService;
    }

    @GetMapping("/email")
    @Operation(summary = "Template Method Pattern", description = "Send email using Template Method Pattern")
    @Parameter(name = "to", description = "Email to send", example = "alice@mail.com")
    @Parameter(name = "msg", description = "Message to send", example = "Hola")
    public String email(@RequestParam String to,
                        @RequestParam String msg) {
        templateNotificationService.sendEmail(to, msg);
        return "Email enviado!";
    }

    @GetMapping("/sms")
    @Operation(summary = "Template Method Pattern", description = "Send SMS using Template Method Pattern")
    @Parameter(name = "to", description = "Email to send", example = "alice@mail.com")
    @Parameter(name = "msg", description = "Message to send", example = "Hola")
    public String sms(@RequestParam String to,
                      @RequestParam String msg) {
        templateNotificationService.sendSms(to, msg);
        return "SMS enviado!";
    }
}
