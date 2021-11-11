package com.magdy.taxiwebappliction.commend.clientcomm;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.util.logging.Logger;

public class ClientCommendDelete implements Commend {
    private ClientService clientService = new ClientService();
    private static final Logger logger = Logger.getLogger(ClientCommendDelete.class.getName());
   private Client client= new Client();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean client =clientService.deleteById(id);
            logger.info("delete" + client);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }


        return new Page("/home.jsp",true,"Success!");
    }
}
