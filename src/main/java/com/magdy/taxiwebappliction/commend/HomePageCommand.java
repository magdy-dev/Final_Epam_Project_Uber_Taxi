package com.magdy.taxiwebappliction.commend;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;

public class HomePageCommand implements Commend{
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServerException {
        return new Page("/home.jsp", true, "Success!");
    }
}
