package com.magdy.taxiwebappliction.utils;

import java.util.ResourceBundle;

public class PropertiesExtractor {


    public static String getValueFromProperties(String key, String propertiesFileName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesFileName);
        return resourceBundle.getString(key);
    }
}
