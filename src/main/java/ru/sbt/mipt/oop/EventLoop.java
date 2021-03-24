package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.processors.Action;
import ru.sbt.mipt.oop.processors.EventProcessor;

import java.util.List;


public class EventLoop {
    public static void eventLoop(SmartHome smartHome, List<EventProcessor> eventProcessors, SensorEvent event) {
        while (event != null) {
            System.out.println("Got event: " + event);

            for (var processor : eventProcessors){
                try {
                    Action action = processor.handleEvent(smartHome, event);
                    if (action != null)
                        smartHome.execute(action);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            event = EventGetter.getNextSensorEvent();
        }
    }
}
