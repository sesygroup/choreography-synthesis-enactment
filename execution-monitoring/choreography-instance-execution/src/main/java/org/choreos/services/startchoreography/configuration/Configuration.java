package org.choreos.services.startchoreography.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Alexander Perucci
 */
public class Configuration {

    private static String PROPERTIES_FILE = "configuration.properties";

    private static Configuration INSTANCE = new Configuration();

    private final Properties properties = new Properties();

    private Properties getProperties() {
        return properties;
    }

    public static String get(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        String value = INSTANCE.getProperties().getProperty(key);
        if (value != null) {
            value.trim();
        }
        return value;

    }

    public static void set(String key, String value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        INSTANCE.getProperties().setProperty(key, value);
    }

    private Configuration() {

        try {
            final ClassLoader loader = this.getClass().getClassLoader();
            final InputStream propFile = loader.getResourceAsStream(PROPERTIES_FILE);
            if (propFile != null) {
                properties.load(propFile);
                propFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
