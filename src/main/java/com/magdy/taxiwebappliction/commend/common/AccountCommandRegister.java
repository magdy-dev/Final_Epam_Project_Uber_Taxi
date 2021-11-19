package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.ClientServiceImpl;
import javax.servlet.http.HttpServletRequest;


public class AccountCommandRegister implements Commend {

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws  ServiceException {

        Client client = new Client();
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

        client.setName(httpServletRequest.getParameter("firstname"));
        client.setLastName(httpServletRequest.getParameter("lastname"));
        client.setPassword(httpServletRequest.getParameter("password"));
        client.setEmail(httpServletRequest.getParameter("email"));
        client.setPhoneNumber(httpServletRequest.getParameter("phoneNumber"));

        client = clientServiceImpl.save(client);
        if (client == null){
            return new Page("/pages/common/registerClient.jsp", true, "Not Success!");
        }
        return new Page("/pages/common/login.jsp", true, "Success!");
    }
}
