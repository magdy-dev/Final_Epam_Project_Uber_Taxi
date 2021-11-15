package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AccountCommandLogin implements Commend {
    private Client client = new Client();
    private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        client = clientServiceImpl.login(username, password);
        System.out.println(username + password);
        if (client == null) {
            return new Page("common/login.jsp", true, "password or username incorrect !");
        }

        return new Page("common/home.jsp", true, "Success!");
    }
}
