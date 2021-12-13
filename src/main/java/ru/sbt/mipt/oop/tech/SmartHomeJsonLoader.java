package ru.sbt.mipt.oop.tech;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Logger;
import ru.sbt.mipt.oop.entities.SmartHome;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SmartHomeJsonLoader implements JsonLoader {
	private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );
	
    public SmartHome readSmartHome(String source) {
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(source)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(json, SmartHome.class);
    }

    public void createJSON(SmartHome smartHome, String output) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        LOGGER.log(jsonString);

        Path path = Paths.get(output);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
