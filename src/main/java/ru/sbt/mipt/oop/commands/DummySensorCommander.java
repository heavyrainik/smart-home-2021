package ru.sbt.mipt.oop.commands;
import java.util.logging.Logger;

public class DummySensorCommander implements SensorCommander {
	//private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );
	
	private DummySensorCommander() {
		throw new IllegalStateException("Utility class");
    }
	
    public static void sendCommand(SensorCommand command) {
		continue;
        //LOGGER.log("Pretend we're sending command " + command);
    }
}
