package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.alarm.Alarm;

public class ActivateAlarmRemoteCommand extends AlarmRemoteCommand {

    public ActivateAlarmRemoteCommand(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void execute(){
        alarm.activate("1");
    }
}
