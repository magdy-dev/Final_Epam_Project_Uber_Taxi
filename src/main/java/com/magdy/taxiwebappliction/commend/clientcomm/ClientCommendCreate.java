package com.magdy.taxiwebappliction.commend.clientcomm;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.util.logging.Logger;

public class ClientCommendCreate implements Commend {

    private ClientService clientService = new ClientService();
    private static final Logger logger = Logger.getLogger(ClientCommendRead.class.getName());
    private Client client = new Client();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServerException {

         try{

            client.setName("name");
            client.setLastName("lastName");
            client.setEmail("email");
            client.setPassword("password");
            client.setPhoneNumber("phoneNumber");
            client = clientService.save(client);
            logger.info("creat" + client);

        } catch (ServiceException e) {
            throw new ServerException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
