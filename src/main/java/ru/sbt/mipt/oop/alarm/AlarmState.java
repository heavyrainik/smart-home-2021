package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.processors.EventProcessor;

public interface AlarmState extends EventProcessor {
    void activate(String code);

    void deactivate(String code);

    void alarm();
}
