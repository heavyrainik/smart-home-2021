package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.Hall;
import ru.sbt.mipt.oop.entities.Room;
import ru.sbt.mipt.oop.entities.SmartHome;

public class CloseHallDoorRemoteCommand extends EntityRemoteCommand{

    public CloseHallDoorRemoteCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute(){
        smartHome.execute((entity -> {
            if (entity instanceof Door){
                Door door = (Door)entity;
                if (isHall()){
                    door.setOpen(false);
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