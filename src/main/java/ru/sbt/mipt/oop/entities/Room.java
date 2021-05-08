package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.processors.Action;

import java.util.Collection;

public class Room implements Actionable {
    private final Collection<Light> lights;
    private final Collection<Door> doors;
    private final String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    @Override
    public void execute(Action action) {
        lights.forEach(light -> light.execute(action));
        doors.forEach(door -> door.execute(action));
    }

    public String getName() {
        return name;
    }
}
