package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.events.SensorEvent;

import static ru.sbt.mipt.oop.events.SensorEventType.*;

public class HallEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public HallEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (isDoorEvent(event) && isHallDoorEvent(smartHome, event)) {
            if (event.getType() == DOOR_CLOSED) {
                Action action = object -> {
                    if (! (object instanceof Light)) { return; }
                    Light light = (Light) object;
                    light.setOn(false);
                };

                smartHome.execute(action);
            }
        }
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_CLOSED || event.getType() == DOOR_OPEN;
    }

    private boolean isHallDoorEvent(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (room instanceof Hall) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
