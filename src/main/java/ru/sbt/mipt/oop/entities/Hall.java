package ru.sbt.mipt.oop.entities;

import java.util.Collection;

public class Hall extends Room {
    public Hall(Collection<Light> lights, Collection<Door> doors, String name) {
        super(lights, doors, name);
    }
}
