package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.rc.RemoteControl;

public interface RemoteControlRegistry {
    void registerRemoteControl(RemoteControl remoteControl, String rcId);
}
