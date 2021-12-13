package com.coolcompany.smarthome.sample;

import java.util.logging.Logger;
import com.coolcompany.smarthome.events.SensorEventsManager;

public class Sample {
	private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );

    public static void main(String[] args) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            LOGGER.log("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
        });
        sensorEventsManager.start();
    }
}
