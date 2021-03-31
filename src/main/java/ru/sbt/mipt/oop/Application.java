package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.*;
import ru.sbt.mipt.oop.tech.SmartHomeJsonLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Application {
    public static void main(String... args) throws IOException {
        String source = "smart-home-1.js";
        // считываем состояние дома из файла
        SmartHome smartHome = SmartHomeJsonLoader.readSmartHome(source);
        // начинаем цикл обработки событий
        SensorEventsManager manager = new SensorEventsManager();

        RegisterProcessors(smartHome, manager);

        manager.start();
    }

    private static List<EventHandler> getEventProcessors(SmartHome smartHome) {
        return Arrays.asList(
                new APIEventHandlerAdapter(smartHome, new LightEventProcessor()),
                new APIEventHandlerAdapter(smartHome, new DoorEventProcessor()),
                new APIEventHandlerAdapter(smartHome, new HallEventProcessor()),
                new APIEventHandlerAdapter(smartHome, new AlarmEventProcessor())
        );
    }

    private static void RegisterProcessors(SmartHome smartHome, SensorEventsManager manager) {
        Collection<EventHandler> processors = getEventProcessors(smartHome);

        for(var processor : processors) {
            manager.registerEventHandler(processor);
        }
    }
}
