package com.coolcompany.smarthome.sample;

import java.util.logging.Logger;
import com.coolcompany.smarthome.events.SensorEventsManager;

public class Sample {

    public static void main(String[] args) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.start();
    }
}
