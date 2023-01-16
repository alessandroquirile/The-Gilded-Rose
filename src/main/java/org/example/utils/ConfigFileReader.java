package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = ConfigFileReader.class.getResourceAsStream("/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}