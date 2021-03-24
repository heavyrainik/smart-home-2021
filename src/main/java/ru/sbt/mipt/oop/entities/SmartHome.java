package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.processors.Action;

import java.util.Collection;

public class SmartHome implements Actionable {
    private final Collection<Room> rooms;

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
    @Override
    public void execute(Action action) {
        rooms.forEach(room -> room.execute(action));
    }
}
