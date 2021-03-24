package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.processors.Action;

import java.util.Collection;

public class Room implements Actionable {
    private final Collection<Light> lights;
    private final Collection<Door> doors;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    @Override
    public void execute(Action action) {
        lights.forEach(light -> light.execute(action));
        doors.forEach(door -> door.execute(action));
    }
}
