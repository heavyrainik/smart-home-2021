package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.events.SensorEvent;

import static ru.sbt.mipt.oop.events.SensorEventType.*;

public class DoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (isDoorEvent(event)) {
            Action action = object -> {
                if (! (object instanceof Door)) { return; }

                Door asDoor = (Door) object;

                if (asDoor.getId().equals(event.getObjectId())) {
                    asDoor.setOpen(event.getType() == DOOR_OPEN);
                }
            };
            smartHome.execute(action);
        }
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
