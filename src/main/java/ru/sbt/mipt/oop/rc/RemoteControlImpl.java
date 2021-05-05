package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.rc_commands.RemoteCommand;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RemoteControlImpl implements RemoteControl {
    private final Map<String, RemoteCommand> controls;

    public RemoteControlImpl(Collection<String> buttons, RemoteCommand defaultCommand) {
        controls = new HashMap<>();
        buttons.forEach(button -> controls.put(button, defaultCommand));
    }

    public RemoteControlImpl(Collection<String> buttons) {
        this(buttons, () -> {});
    }

    public void setCommandForButton(String button, RemoteCommand command) {
        if (command != null) {
            controls.replace(button, command);
        }
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        RemoteCommand command = controls.get(buttonCode);
        if (command != null) {
            command.execute();
        }
    }
}