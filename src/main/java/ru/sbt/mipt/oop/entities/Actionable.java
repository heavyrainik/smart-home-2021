package ru.sbt.mipt.oop.entities;

import ru.sbt.mipt.oop.processors.Action;

public interface Actionable {
    void execute(Action action);
}
