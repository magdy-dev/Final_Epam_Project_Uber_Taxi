package com.magdy.taxiwebappliction.commend.clientcomm;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class ClientCommendUpdate implements Commend {

    private static final Logger logger = Logger.getLogger(ClientCommendRead.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
        Client client = new Client();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));

            client.setName(httpServletRequest.getParameter("name"));
            client.setLastName(httpServletRequest.getParameter("lastName"));
            client.setEmail(httpServletRequest.getParameter("email"));
            client.setPassword(httpServletRequest.getParameter("password"));
            client.setPhoneNumber(httpServletRequest.getParameter("phoneNumber"));
            client = clientServiceImpl.update(client);
            logger.info("update" + client);

        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }

}
