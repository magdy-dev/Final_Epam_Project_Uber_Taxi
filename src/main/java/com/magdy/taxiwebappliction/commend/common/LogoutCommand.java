package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Commend {



    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("client");
        session.removeAttribute("driver");
        session.removeAttribute("order");
        session.removeAttribute("addr_to");
        session.removeAttribute("addr_from");
        session.removeAttribute("isCash");
        session.removeAttribute("from");
        session.removeAttribute("to");
        session.removeAttribute("message");
        session.removeAttribute("rides");

        return new Page("/index.jsp", true, "Success!");
    }
}
