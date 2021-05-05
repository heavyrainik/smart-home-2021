package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;

public interface EventProcessor {
    void handleEvent(SensorEvent event);
}
