package de.telran.processor.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfigService {
    private Properties prop = new Properties();

    public FileConfigService() throws Exception {
        loadProperties();
    }

    public String getPathToSavedImages(String path_to_saves_images) {
        return prop.getProperty("path_to_saves_images");
    }

    private void loadProperties() throws IOException {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("application.properties");
            if (stream == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }
            prop.load(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
