package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ClientServiceImpl;
import com.magdy.taxiwebappliction.service.DriverServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountCommandLogin implements Commend {
    private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
    private DriverServiceImpl driverService = new DriverServiceImpl();


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        Client client = clientServiceImpl.login(username, password);
        Driver driver = driverService.login(username, password);
        if (client == null && driver == null) {
            return new Page("/pages/common/login.jsp", true, "password or username incorrect !");
        }
        HttpSession session = httpServletRequest.getSession();
        if (client != null){
            session.setAttribute("client", client);
            return new Page("/pages/client/orderClient.jsp", true, "Success!");
        }

        session.setAttribute("driver", driver);
        return new Page("/pages/driver/orderDriver.jsp", true, "Success!");
    }
}
