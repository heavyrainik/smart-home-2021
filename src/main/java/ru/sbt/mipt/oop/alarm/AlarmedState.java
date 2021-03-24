package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.Action;

public class AlarmedState implements AlarmState{
    private final Alarm alarm;
    private final String code;

    AlarmedState(Alarm alarm, String code){
        this.alarm = alarm;
        this.code = code;
    }
    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {
        if (code.equals(this.code)) {
            alarm.setState(new DeactivatedAlarm(alarm));
        }
    }

    @Override
    public void alarm() {

    }

    @Override
    public Action handleEvent(SmartHome smartHome, SensorEvent event) {
        return null;
    }
}