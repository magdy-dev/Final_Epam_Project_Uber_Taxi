package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Command {
    Page execute(HttpServletRequest httpServletRequest) throws ServiceException;
}
