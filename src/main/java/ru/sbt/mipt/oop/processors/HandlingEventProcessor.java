package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;

import java.util.List;

public class HandlingEventProcessor implements EventHandler {
    private final List<EventProcessor> EventProcessors;

    public HandlingEventProcessor(List<EventProcessor> EventProcessors) {
        this.EventProcessors = EventProcessors;
    }

    @Override
    public void handle(SensorEvent sensorEvent) {
        for (EventProcessor eventProcessor : EventProcessors) {
            eventProcessor.handleEvent(sensorEvent);
        }
    }
}
