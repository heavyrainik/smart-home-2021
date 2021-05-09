package ru.sbt.mipt.oop.rc;

import java.util.HashMap;

public class DummyRemoteControlRegistry implements RemoteControlRegistry {
    HashMap<String, RemoteControl> remoteControls;

    public DummyRemoteControlRegistry() {
        remoteControls = new HashMap<>();
    }

    @Override
    public void registerRemoteControl(RemoteControl remoteControl, String rcId) {
        if (!remoteControls.containsKey(rcId)) {
            remoteControls.put(rcId, remoteControl);
        }
    }

    public RemoteControl getRemoteControl(String rcId) {
        return remoteControls.getOrDefault(rcId, null);
    }

    public void onButtonPressed(String buttonCode, String rcId) {
        if (remoteControls.containsKey(rcId)) {
            remoteControls.get(rcId).onButtonPressed(buttonCode);
        }
    }
}
