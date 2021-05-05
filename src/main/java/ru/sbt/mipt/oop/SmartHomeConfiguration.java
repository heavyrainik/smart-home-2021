package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.alarm.*;
import ru.sbt.mipt.oop.commands.DummySensorCommander;
import ru.sbt.mipt.oop.commands.SensorCommander;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.events.SensorEventType;
import ru.sbt.mipt.oop.processors.*;
import ru.sbt.mipt.oop.rc.RemoteControlImpl;
import ru.sbt.mipt.oop.rc.DummyRemoteControlRegistry;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.rc_commands.*;
import ru.sbt.mipt.oop.tech.SmartHomeJsonLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

@Configuration
public class SmartHomeConfiguration {
    @Bean
    SmartHomeJsonLoader smartHomeJsonLoader() {
        return new SmartHomeJsonLoader();
    }

    @Bean
    String smartHomePath() {
        return "smart-home-1.js";
    }

    @Bean
    SmartHome smartHome(SmartHomeJsonLoader smartHomeJsonLoader) throws IOException {
        return smartHomeJsonLoader.readSmartHome(smartHomePath());
    }

    @Bean
    EventProcessor lightEventProcessor(SmartHome smartHome) {
        return new LightEventProcessor(smartHome);
    }

    @Bean
    EventProcessor hallEventProcessor(SmartHome smartHome) {
        return new HallEventProcessor(smartHome);
    }

    @Bean
    EventProcessor doorEventProcessor(SmartHome smartHome) {
        return new DoorEventProcessor(smartHome);
    }

    @Bean
    EventProcessor alarmEventProcessor(SmartHome smartHome) {
        return new AlarmEventProcessor(smartHome);
    }

    @Bean
    SensorCommander sensorCommander() {
        return new DummySensorCommander();
    }

    @Bean
    EventHandler eventHandler(Collection<EventProcessor> eventProcessorCollection) {
        return new HandlingEventProcessor(new ArrayList<>(eventProcessorCollection));
    }

    @Bean
    Map<String, SensorEventType> eventTranslator() {
        return Map.ofEntries(
                entry("LightIsOn", SensorEventType.LIGHT_ON),
                entry("LightIsOff", SensorEventType.LIGHT_OFF),
                entry("DoorIsOpen", SensorEventType.DOOR_OPEN),
                entry("DoorIsClosed", SensorEventType.DOOR_CLOSED)
        );
    }

    @Bean
    String alarmAccessCode() {
        return "1";
    }

    @Bean
    Alarm activatedAlarm(SmartHome smartHome, String alarmAccessCode) {
        Alarm alarm = new Alarm(smartHome);
        alarm.activate(alarmAccessCode);
        return alarm;
    }

    @Bean
    Notifier intrusionNotifier() {
        return new SmsNotifier();
    }

    @Bean
    EventHandler protectedEventProcessor(EventHandler eventHandler, Alarm activatedAlarm, Notifier notifier) {
        eventHandler = new BlockerOnAlarm(eventHandler, activatedAlarm, notifier);
        eventHandler = new CheckerForAlarm(eventHandler, activatedAlarm);
        return eventHandler;
    }

    @Bean
    com.coolcompany.smarthome.events.EventHandler adaptedSensorEventHandler(EventHandler protectedEventProcessor, Map<String, SensorEventType> eventTranslator) {
        return new EventHandlerAdapter(protectedEventProcessor, eventTranslator);
    }

    @Bean
    SensorEventsManager sensorEventsManager(com.coolcompany.smarthome.events.EventHandler adaptedSensorEventHandler) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(adaptedSensorEventHandler);
        return sensorEventsManager;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry(RemoteControl remoteControl, String rcId) {
        RemoteControlRegistry rcr = new DummyRemoteControlRegistry();
        rcr.registerRemoteControl(remoteControl, rcId);
        return rcr;
    }

    @Bean
    String rcId() {
        return "1";
    }

    @Bean(name="buttonACommand")
    RemoteCommand activateAlarmRemoteCommand(Alarm activatedAlarm) {
        return new ActivateAlarmRemoteCommand(activatedAlarm);
    }

    @Bean(name="buttonBCommand")
    RemoteCommand closeHallDoorRemoteCommand(SmartHome smartHome) {
        return new CloseHallDoorRemoteCommand(smartHome);
    }

    @Bean(name="buttonCCommand")
    RemoteCommand alarmAlarmRemoteCommand(Alarm activatedAlarm) {
        return new AlarmAlarmRemoteCommand(activatedAlarm);
    }

    @Bean(name="buttonDCommand")
    RemoteCommand turnOffLightsRemoteCommand(SmartHome smartHome) {
        return new TurnOffLightsRemoteCommand(smartHome);
    }

    @Bean(name="button1Command")
    RemoteCommand turnOnLightsRemoteCommand(SmartHome smartHome) {
        return new TurnOnLightsRemoteCommand(smartHome);
    }

    @Bean(name="button2Command")
    RemoteCommand turnOnHallLightsRemoteCommand(SmartHome smartHome) {
        return new TurnOnHallLightsRemoteCommand(smartHome);
    }

    @Bean
    List<String> rcButtons() {
        return List.of("A", "B", "C", "D", "1", "2", "3", "4");
    }

    @Bean
    RemoteControl remoteControl(@Qualifier("rcButtons") List<String> rcButtons, ListableBeanFactory beanFactory) {
        RemoteControlImpl rc = new RemoteControlImpl(rcButtons);
        Map<String, RemoteCommand> commands = beanFactory.getBeansOfType(RemoteCommand.class);
        rcButtons.forEach(button -> rc.setCommandForButton(button, commands.get("button" + button + "Command")));
        return rc;
    }
}
