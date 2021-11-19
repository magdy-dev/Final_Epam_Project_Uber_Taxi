package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.util.List;

public class AccountCommandLogin implements Commend {
    private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
    private DriverServiceImpl driverService = new DriverServiceImpl();
    private RideServiceImpl rideService = new RideServiceImpl();

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
        List<Ride> rides = rideService.selectAll();

        session.setAttribute("rides", rides);
        return new Page("/pages/driver/ordersDriver.jsp", true, "Success!");
    }
}
