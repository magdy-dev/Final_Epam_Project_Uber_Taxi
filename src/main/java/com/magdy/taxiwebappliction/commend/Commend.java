package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Commend {
    Page execute(HttpServletRequest httpServletRequest) throws ServiceException;
}
