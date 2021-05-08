package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;

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
}
