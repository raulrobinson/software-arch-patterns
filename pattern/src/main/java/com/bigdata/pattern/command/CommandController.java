package com.bigdata.pattern.command;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${controller.properties.base-path}/command")
@Tag(name = "Command", description = "Command operations")
public class CommandController {

    private final ReceiverLight receiverLight = new ReceiverLight();
    private final InvokerRemoteControl remote = new InvokerRemoteControl();

    @PostMapping("/on")
    @Operation(summary = "Command Pattern", description = "Turn on light using Command Pattern")
    public String turnOnLight() {
        remote.setCommand(new TurnOnLightCommand(receiverLight));
        remote.pressButton();
        return "Comando encender ejecutado";
    }

    @PostMapping("/off")
    @Operation(summary = "Command Pattern", description = "Turn off light using Command Pattern")
    public String turnOffLight() {
        remote.setCommand(new TurnOffLightCommand(receiverLight));
        remote.pressButton();
        return "Comando apagar ejecutado";
    }
}
