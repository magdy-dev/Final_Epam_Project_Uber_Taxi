package com.magdy.taxiwebappliction.commend.clientcomm;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.ClientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ClientCommendDelete implements Commend {
    private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
    private static final Logger log= (Logger) LogManager.getLogger();
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        long id = Long.parseLong(httpServletRequest.getParameter("clientId"));
        boolean client = clientServiceImpl.deleteById(id);
        List<Client> clientList = clientServiceImpl.selectAll();
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("clientList", clientList);

        return new Page("/pages/owner/ownerHomePage.jsp", true, "Success!");

    }
}
