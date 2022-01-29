package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements Command {
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        return new Page("/home.jsp", true, "Success!");
    }
}
