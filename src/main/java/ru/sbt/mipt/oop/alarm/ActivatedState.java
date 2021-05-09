package ru.sbt.mipt.oop.alarm;

public class ActivatedState implements AlarmState{
    private final Alarm alarm;
    private final String code;

    public ActivatedState(Alarm alarm, String code){
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
        } else {
            alarm();
        }
    }

    @Override
    public void alarm() {
        alarm.setState(new AlarmedState(alarm, code));
    }
}
