package ru.sbt.mipt.oop.tech;

import ru.sbt.mipt.oop.entities.SmartHome;

public interface JsonLoader {
    SmartHome readSmartHome(String source);

    void createJSON(SmartHome smartHome, String output);
}
