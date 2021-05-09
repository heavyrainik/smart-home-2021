package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.processors.Action;

public class Door implements Actionable {
    private boolean isOpen;
    private String id;

    public Door(String id, boolean isOpen) {
        this.id = id;
        this.isOpen = isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getId() {
        return id;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
