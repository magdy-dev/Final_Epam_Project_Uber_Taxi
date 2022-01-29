package com.magdy.taxiwebappliction.commend;

import java.util.Locale;

public class Page {

    private String url;
    private boolean redirect;
    private String message;
    public static final String MAIN_PAGE_PATH = "/pages/common/main.jsp";
    public static final Locale DEFAULT_LOCALE = new Locale("en", "US");


    public Page(String url, boolean redirect, String message){
        this.url= url;
        this.redirect= redirect;
        this.message= message;
    }

    public String getUrl() {
        return url;
    }

    public boolean isRedirect() {
        return redirect;
    }
}
