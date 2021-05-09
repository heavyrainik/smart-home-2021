package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;

import static ru.sbt.mipt.oop.events.SensorEventType.*;

public class LightEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (isLightEvent(event)) {
            Action action = object -> {
                if (! (object instanceof Light)) { return; }

                Light light = (Light) object;

                if (light.getId().equals(event.getObjectId())) {
                    light.setOn(event.getType() == LIGHT_ON);
                }
            };

            smartHome.execute(action);
        }
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
