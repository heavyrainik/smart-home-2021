package ru.sbt.mipt.oop.alarm;

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
		//This method can't be used for deactivated alarm
    }

    @Override
    public void alarm() {
		//This method can't be used for deactivated alarm
    }
}
