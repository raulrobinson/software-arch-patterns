package com.bigdata.patterns.command;

public class TurnOnLightCommand implements Command {

    private final ReceiverLight receiverLight;

    public TurnOnLightCommand(ReceiverLight receiverLight) {
        this.receiverLight = receiverLight;
    }

    @Override
    public void execute() {
        receiverLight.turnOn();
    }
}
