package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.processors.EventHandler;

public class BlockerOnAlarm implements EventHandler {
    private final EventHandler eventHandler;
    private final Alarm alarm;
    private final Notifier notifier;

    public BlockerOnAlarm(EventHandler eventHandler, Alarm alarm, Notifier notifier) {
        this.eventHandler = eventHandler;
        this.alarm = alarm;
        this.notifier = notifier;
    }

    @Override
    public void handle(SensorEvent event) {
        if (alarm.isAlarmed()) {
            notifier.notifyOwner();
        } else {
            eventHandler.handle(event);
        }
    }
}
