package com.magdy.taxiwebappliction.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {

    public static final Locale DEFAULT_LOCALE = new Locale("en", "US");

    private MessageManager() {
    }

    public static void changeLocale(Locale locale) {
        ResourceBundle.getBundle("page_content", locale);
    }
}
