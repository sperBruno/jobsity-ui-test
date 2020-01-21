package com.womenshop.core.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesInfo {
    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class.getSimpleName());
    private static final String CONFIG_PROPERTIES = "gradle.properties";
    private static final String URL = "url";
    private static final String BROWSER = "browser";

    private static PropertiesInfo instance;
    private Properties properties;

    private PropertiesInfo() {
        loadProperties();
    }

    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    private void loadProperties() {
        try {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
                properties = new Properties();
                properties.load(fileInputStream);
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e);
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e);
        }
    }

    public String getProperty(String propertyKey) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
    }

    public String getUrl() {
        return getProperty(URL);
    }

    public String getBrowser() {
        return getProperty(BROWSER);
    }
}
