package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.ClientService;
import javax.servlet.http.HttpServletRequest;


public class AccountCommandRegister implements Commend {

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws  ServiceException {

        Client client = new Client();
        ClientService clientService = new ClientService();

        client.setName(httpServletRequest.getParameter("firstname"));
        client.setLastName(httpServletRequest.getParameter("lastname"));
        client.setPassword(httpServletRequest.getParameter("password"));
        client.setEmail(httpServletRequest.getParameter("email"));
        client.setPhoneNumber(httpServletRequest.getParameter("phoneNumber"));

        client = clientService.save(client);


        return new Page("/login.jsp", true, "Success!");
    }
}
