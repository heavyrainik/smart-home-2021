package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;

public interface EventProcessor {
    Action handleEvent(SmartHome smartHome, SensorEvent event);
}
