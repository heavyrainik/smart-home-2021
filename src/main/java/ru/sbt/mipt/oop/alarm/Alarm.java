package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;

public class Alarm implements AlarmState {
    private AlarmState state;
    private final SmartHome smartHome;

    public Alarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void activate(String code) {
        state = new ActivatedState(this, code);
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

    public boolean isAlarmed() {
        return state instanceof AlarmedState;
    }

    public boolean isActivated() {
        return state instanceof ActivatedState;
    }

    @Override
    public void handleEvent(SensorEvent event) {}
}
