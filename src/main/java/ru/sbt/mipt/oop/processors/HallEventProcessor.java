package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.commands.CommandType;
import ru.sbt.mipt.oop.commands.SensorCommand;
import ru.sbt.mipt.oop.entities.*;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.events.SensorEventType;

import static ru.sbt.mipt.oop.events.SensorEventType.*;

public class HallEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public HallEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (!isDoorEvent(event)) {
            return;
        }

        Action turnEveryLightOff = (lightObject) -> {
            if (lightObject instanceof Light) {
                Light light = (Light) lightObject;
                light.setOn(false);
            }
        };

        String targetId = event.getObjectId();

        Action checkHallDoor = (doorObject) -> {
            if (doorObject instanceof Door && ((Door) doorObject).getId().equals(targetId)) {
                smartHome.execute(turnEveryLightOff);
            }
        };

        smartHome.execute((roomObject) -> {
            if (roomObject instanceof Room) {
                Room room = (Room) roomObject;
                if ("hall".equals(room.getName())) {
                    room.execute(checkHallDoor);
                }
            }
        });
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_CLOSED || event.getType() == DOOR_OPEN;
    }

}
