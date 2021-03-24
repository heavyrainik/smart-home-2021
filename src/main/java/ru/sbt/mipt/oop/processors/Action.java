package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.entities.Actionable;

public interface Action {
    void execute(Actionable item);
}
