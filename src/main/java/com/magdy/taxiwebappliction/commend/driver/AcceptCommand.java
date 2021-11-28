package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AcceptCommand implements Commend {

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
        HttpSession session = httpServletRequest.getSession();
        Driver driver = (Driver) session.getAttribute("driver");
        Long orderId = Long.valueOf(httpServletRequest.getParameter("orderId"));
        Long rideId = Long.valueOf(httpServletRequest.getParameter("rideId"));
        List<Ride> rides = (List<Ride>) session.getAttribute("rides");
        List<Ride> next = new ArrayList<>();
        for (Ride r : rides) {
            if (r.getId() == rideId) {
                continue;
            }
            next.add(r);
        }
        session.setAttribute("rides", next);
        try {
            driverServiceImpl.accept(driver, orderId);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

        return new Page("/pages/driver/ordersDriver.jsp", true, "Success!");
    }
}
