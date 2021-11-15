package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Commend {
    Page execute(HttpServletRequest httpServletRequest) throws ServiceException;
}
