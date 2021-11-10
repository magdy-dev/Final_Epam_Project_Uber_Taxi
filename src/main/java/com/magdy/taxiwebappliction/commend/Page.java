package com.magdy.taxiwebappliction.commend;

public class Page {

    private String url;
    private boolean redirect;
    private String message;

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
