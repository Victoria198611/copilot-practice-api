package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigLoader loads configuration value from a properties file.
 * It allows retrieving values like API keys or Base URls
 * without hardcoding them in the source code.
    */
public class ConfigLoader {
    private Properties properties;

    public ConfigLoader(String filePath) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration from " + filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
