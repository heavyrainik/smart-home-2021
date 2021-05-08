package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.processors.Action;

public class CloseHallDoorRemoteCommand extends EntityRemoteCommand{

    public CloseHallDoorRemoteCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute(){
        Action closeDoors = (entity) -> {
            if (entity instanceof Door) {
                ((Door) entity).setOpen(false);
            }
        };

        smartHome.execute((entity) -> {
            if (entity instanceof Room) {
                Room room = (Room) entity;

                if ("hall".equals(room.getName())) {
                    room.execute(closeDoors);
                }
            }
        });
    }
}