package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.EventProcessor;

public class Alarm {
    private AlarmState state;

    public Alarm() {
        //virtual
    }

    public void activate(String code) {
        state = new ActivatedState(this, code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

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

}
