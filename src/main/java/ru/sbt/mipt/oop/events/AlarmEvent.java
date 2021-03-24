package ru.sbt.mipt.oop.events;

public class AlarmEvent extends SensorEvent{
    private final String code;

    public AlarmEvent(SensorEventType type, String objectId, String code) {
        super(type, objectId);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
