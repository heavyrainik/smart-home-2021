package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.alarm.Alarm;

public class AlarmAlarmRemoteCommand extends AlarmRemoteCommand {

    public AlarmAlarmRemoteCommand(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void execute(){
        alarm.alarm();
    }
}
