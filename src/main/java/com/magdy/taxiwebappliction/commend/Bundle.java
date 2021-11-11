package com.magdy.taxiwebappliction.commend;

import java.util.Locale;
import java.util.ResourceBundle;

public class Bundle {

    private static void il8n(){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("");
        System.out.println(resourceBundle.getString("language") + ":" + resourceBundle.getString("language"));

        Locale.setDefault(new Locale("fr","FR"));

    }
}