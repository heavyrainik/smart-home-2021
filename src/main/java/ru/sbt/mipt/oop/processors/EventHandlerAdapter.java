package ru.sbt.mipt.oop.processors;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.events.SensorEventType;

import java.util.Map;

public class EventHandlerAdapter implements com.coolcompany.smarthome.events.EventHandler {
    private final EventHandler eventHandler;
    private final Map<String, SensorEventType> eventTranslator;

    public EventHandlerAdapter(EventHandler eventHandler, Map<String, SensorEventType> translator) {
        this.eventHandler = eventHandler;
        this.eventTranslator = translator;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent translated = translate(event);
        if (translated != null) {
            eventHandler.handle(translated);
        }
    }

    private SensorEvent translate(CCSensorEvent event) {
        SensorEventType type = eventTranslator.get(event.getEventType());

        if (type == null) {
            return null;
        }

        return new SensorEvent(type, event.getObjectId());
    }
}