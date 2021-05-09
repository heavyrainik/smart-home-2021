package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.SmartHome;

public class TurnOffLightsRemoteCommand extends EntityRemoteCommand {

    public TurnOffLightsRemoteCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
        smartHome.execute((component -> {
            if (component instanceof Light) {
                Light light = (Light) component;
                light.setOn(false);
            }
        }));
    }
}