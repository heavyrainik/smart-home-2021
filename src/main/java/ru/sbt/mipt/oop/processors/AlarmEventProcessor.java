package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.AlarmEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.alarm.Alarm;

import static ru.sbt.mipt.oop.events.SensorEventType.*;

public class AlarmEventProcessor implements EventProcessor{
    @Override
    public Action handleEvent(SmartHome smartHome, SensorEvent event) {
        if (isAlarmEvent(event)) {
            Action action = object -> {
                if (object instanceof Alarm) {
                    Alarm signalization = (Alarm) object;
                    if (event.getType() == ALARM_ACTIVATE) {
                        signalization.activate(((AlarmEvent) event).getCode());
                    } else {
                        signalization.deactivate(((AlarmEvent) event).getCode());
                    }
                }
            };

            smartHome.execute(action);
        }
        return null;
    }

    private boolean isAlarmEvent(SensorEvent event){
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}