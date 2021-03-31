package ru.sbt.mipt.oop.processors;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.events.SensorEventType;

public class APIEventHandlerAdapter implements EventHandler {
    private final EventProcessor processor;
    private final SmartHome smartHome;

    public APIEventHandlerAdapter(SmartHome smartHome, EventProcessor processor) {
        this.smartHome = smartHome;
        this.processor = processor;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent translated = translate(event);
        if (translated != null) {
            processor.handleEvent(smartHome, translated);
        }
    }

    private SensorEvent translate(CCSensorEvent event) {
        SensorEventType type;

        switch (event.getEventType()) {
            case "LightIsOn":
                type = SensorEventType.LIGHT_ON;
                break;

            case "LightIsOff":
                type = SensorEventType.LIGHT_OFF;
                break;

            case "DoorIsOpen":
                type = SensorEventType.DOOR_OPEN;
                break;

            case "DoorIsClosed":
                type = SensorEventType.DOOR_CLOSED;
                break;

            default:
                return null;
        }

        return new SensorEvent(type, event.getObjectId());
    }
}
