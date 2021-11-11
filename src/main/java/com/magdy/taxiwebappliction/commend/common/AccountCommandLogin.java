package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;

public class AccountCommandLogin implements Commend {
    private Client client = new Client();
    private ClientService clientService = new ClientService();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        String username = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
        client = clientService.login(username, password);

        if (client == null) {
            return new Page("/login.jsp", true, "password or username incorrect !");
        }

        return new Page("/home.jsp", true, "Success!");
    }
}
