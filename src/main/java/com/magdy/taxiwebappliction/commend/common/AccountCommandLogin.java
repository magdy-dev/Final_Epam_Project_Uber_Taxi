package com.magdy.taxiwebappliction.commend.common;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class AccountCommandLogin implements Commend {
    private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
    private DriverServiceImpl driverService = new DriverServiceImpl();
    private RideServiceImpl rideService = new RideServiceImpl();
    private OwnerServiceImpl ownerService = new OwnerServiceImpl();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        Client client = clientServiceImpl.login(username, password);
        Driver driver = driverService.login(username, password);
        Owner owner = ownerService.login(username, password);
        if (client == null && driver == null && owner == null) {
            return new Page("/pages/common/login.jsp", true, "password or username incorrect !");
        }
        HttpSession session = httpServletRequest.getSession();
        if (client != null) {

            session.setAttribute("client", client);
            List<Ride> ridesClientHistory = rideService.selectAllByDriverId(client.getId());
            session.setAttribute("ridesClientHistory", ridesClientHistory);
            return new Page("/pages/client/orderClient.jsp", true, "Success!");
        }
        if (driver != null) {
            session.setAttribute("driver", driver);
            List<Ride> rides = rideService.selectAll();
            List<Ride> ridesDriverHistory = rideService.selectAllByDriverId(driver.getId());
            session.setAttribute("rides", rides);
            session.setAttribute("ridesDriverHistory", ridesDriverHistory);
            return new Page("/pages/driver/ordersDriver.jsp", true, "Success!");

        }
        session.setAttribute("owner", owner);
        List<Driver>driverList=driverService.selectAll();
        List<Client>clientList=clientServiceImpl.selectAll();
        session.setAttribute("driverList",driverList);
        session.setAttribute("clientList",clientList);
        return new Page("/pages/owner/ownerHomePage.jsp", true, "Success!");




    }
}
