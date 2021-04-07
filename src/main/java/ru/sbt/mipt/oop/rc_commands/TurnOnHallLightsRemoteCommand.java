package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.entities.Hall;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.Room;
import ru.sbt.mipt.oop.entities.SmartHome;

public class TurnOnHallLightsRemoteCommand extends EntityRemoteCommand{

    public TurnOnHallLightsRemoteCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute(){
        smartHome.execute((entity -> {
            if (entity instanceof Light){
                Light light = (Light)entity;
                if (isHall()){
                    light.setOn(true);
                }
            }
        }));
    }

    private boolean isHall() {
        for (Room room : smartHome.getRooms()) {
            if (room instanceof Hall) {
                return true;
            }
        }

        return false;
    }
}

