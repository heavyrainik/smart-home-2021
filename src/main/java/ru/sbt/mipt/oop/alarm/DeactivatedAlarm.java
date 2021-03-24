package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.Action;

public class DeactivatedAlarm implements AlarmState{
    private final Alarm alarm;

    public DeactivatedAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        alarm.setState(new ActivatedState(alarm, code));
    }

    @Override
    public void deactivate(String code) {

    }

    @Override
    public void alarm() {

    }

    @Override
    public Action handleEvent(SmartHome smartHome, SensorEvent event) {
        return null;
    }
}
