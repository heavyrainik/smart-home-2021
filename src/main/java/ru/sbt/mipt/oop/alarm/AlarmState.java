package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.entities.Actionable;

public interface AlarmState extends Actionable {
    void activate(String code);

    void deactivate(String code);

    void alarm();
}
