package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.processors.EventHandler;

public class CheckerForAlarm implements EventHandler {
    private final EventHandler eventHandler;
    private final Alarm alarm;

    public CheckerForAlarm(EventHandler eventHandler, Alarm alarm) {
        this.eventHandler = eventHandler;
        this.alarm = alarm;
    }

    @Override
    public void handle(SensorEvent event) {
        if (alarm.isActivated() && event != null) {
            alarm.alarm();
        }

        eventHandler.handle(event);
    }
}
