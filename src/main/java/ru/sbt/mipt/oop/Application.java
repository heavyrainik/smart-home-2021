package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.processors.*;
import ru.sbt.mipt.oop.tech.SmartHomeJsonLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) throws IOException {
        String source = "smart-home-1.js";
        // считываем состояние дома из файла
        SmartHome smartHome = SmartHomeJsonLoader.readSmartHome(source);
        // начинаем цикл обработки событий
        EventLoop.eventLoop(smartHome, getEventProcessors(), EventGetter.getNextSensorEvent());
    }

    private static List<EventProcessor> getEventProcessors() {
        return Arrays.asList(
                new LightEventProcessor(),
                new DoorEventProcessor(),
                new HallEventProcessor(),
                new AlarmEventProcessor()
        );
    }
}
