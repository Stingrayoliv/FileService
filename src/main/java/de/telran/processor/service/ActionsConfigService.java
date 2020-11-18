package de.telran.processor.service;

import de.telran.processor.factory.ImageActionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ActionsConfigService {
    private Properties prop = new Properties();

    public ActionsConfigService() {
        loadProperties();
    }

    public void loadProperties() {
        try (
                InputStream input = ImageActionFactory.class
                        .getClassLoader()
                        .getResourceAsStream("actions.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find actions.properties");
                return;
            }
            //Reads a property list (key and element pairs) from the input byte stream.
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getActionPackage(){
        return (String) prop.get("action.package");
    }

    private List<String> getActionClassNames(){
        return Arrays.asList(((String) prop.get("action.names")).split(","));
    }
}
