package ru.sbt.mipt.oop.commands;
import java.util.logging.Logger;

public class DummySensorCommander implements SensorCommander {
	private static final Logger LOGGER = Logger.getLogger( DummySensorCommander.class.getName() );
	
	private DummySensorCommander() {
		throw new IllegalStateException("Utility class");
    }
	
    public static void sendCommand(SensorCommand command) {
        LOGGER.log();
    }
}
