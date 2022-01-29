package com.magdy.taxiwebappliction.commend.clientcomm;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.ClientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class ClientCommandRead implements Command {

    private static final Logger log= (Logger) LogManager.getLogger();
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
        Client client = new Client();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            client = clientServiceImpl.selectById(id);
            log.info("reade" + client);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

        return new Page("/home.jsp", true, "Success!");
    }
}
