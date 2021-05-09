package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;

public interface EventHandler {
    void handle(SensorEvent sensorEvent);
}
