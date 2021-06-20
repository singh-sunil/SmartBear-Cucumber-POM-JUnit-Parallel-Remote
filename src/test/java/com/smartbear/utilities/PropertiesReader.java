package com.smartbear.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final String AUTOMATION_CONFIG_FILEPATH = "./automationConfig.properties";

    public static String getValue(String key) throws FileNotFoundException, IOException {

        File file = new File(AUTOMATION_CONFIG_FILEPATH);
        if (!file.exists()) {
            throw new FileNotFoundException("This file doesnot exist in the path specified " + file.toString());
        } else {
            System.out.println("Welcome, we got into file " + file.toString());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public Long getTimeout() throws FileNotFoundException, IOException {
        String timeout = PropertiesReader.getValue("timeout");
        return Long.parseLong(timeout);
    }
}
