package ru.sbt.mipt.oop;

public class DummySensorCommander implements SensorCommander{
    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}