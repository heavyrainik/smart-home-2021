package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.Action;

public class Alarm implements AlarmState {
    private AlarmState state;

    @Override
    public void activate(String code) {
        state.activate(code);
    }

    @Override
    public void deactivate(String code) {
        state.deactivate(code);
    }

    @Override
    public void alarm() {
        state.alarm();
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    @Override
    public Action handleEvent(SmartHome smartHome, SensorEvent event) {
        return null;
    }
}
