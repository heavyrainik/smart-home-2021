package ru.sbt.mipt.oop.alarm;


import ru.sbt.mipt.oop.entities.Actionable;
import ru.sbt.mipt.oop.processors.Action;

public class Alarm implements Actionable {
    private AlarmState state;

    public void activate(String code) {
        state.activate(code);
    }

    public void deactivate(String code) {
        state.deactivate(code);
    }

    public void alarm() {
        state.alarm();
    }

    void setState(AlarmState state) {
        this.state = state;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
