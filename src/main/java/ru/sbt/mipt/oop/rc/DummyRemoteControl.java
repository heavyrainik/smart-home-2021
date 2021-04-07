package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.rc_commands.RemoteCommand;

import java.util.HashMap;

public class DummyRemoteControl implements RemoteControl{
    private final HashMap<String, RemoteCommand> Commands;

    public DummyRemoteControl() {
        this.Commands = new HashMap<>();
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (Commands.containsKey(buttonCode)){
            Commands.get(buttonCode).execute();
        }
    }
}
