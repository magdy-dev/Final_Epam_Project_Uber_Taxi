package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;

public class HomePageCommand implements Commend{
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        return new Page("/home.jsp", true, "Success!");
    }
}
