package ru.sbt.mipt.oop.commands;
import java.util.logging.Logger;

public class DummySensorCommander implements SensorCommander {
	private static final Logger LOGGER = Logger.getLogger( DummySensorCommander.class.getName() );
	
	public DummySensorCommander() {}
	
    public static void sendCommand(SensorCommand command) {
        LOGGER.info(LOGGER.getName());
    }
}
