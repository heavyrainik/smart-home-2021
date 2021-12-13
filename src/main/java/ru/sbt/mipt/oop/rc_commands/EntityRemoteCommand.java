package ru.sbt.mipt.oop.rc_commands;

import ru.sbt.mipt.oop.entities.SmartHome;

public class EntityRemoteCommand implements RemoteCommand {
    protected final SmartHome smartHome;

    public EntityRemoteCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
		//Virtual method
	}
}
