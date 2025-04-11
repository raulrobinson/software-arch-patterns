package com.bigdata.pattern.command;

public class TurnOffLightCommand implements Command {

    private final ReceiverLight receiverLight;

    public TurnOffLightCommand(ReceiverLight receiverLight) {
        this.receiverLight = receiverLight;
    }

    @Override
    public void execute() {
        receiverLight.turnOff();
    }
}
