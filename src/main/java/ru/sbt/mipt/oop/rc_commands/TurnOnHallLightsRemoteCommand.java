package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.entities.Hall;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.Room;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.Action;

public class TurnOnHallLightsRemoteCommand extends EntityRemoteCommand{

    public TurnOnHallLightsRemoteCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute(){
        Action turnLightOn = (lightObject) -> {
            if (lightObject instanceof Light) {
                ((Light) lightObject).setOn(true);
            }
        };

        smartHome.execute((entity) -> {
            if (entity instanceof Room) {
                Room room = (Room) entity;

                if ("hall".equals(room.getName())) {
                    room.execute(turnLightOn);
                }
            }
        });
    }
}

