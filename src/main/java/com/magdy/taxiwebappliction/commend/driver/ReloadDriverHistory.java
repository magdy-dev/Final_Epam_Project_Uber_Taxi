package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.service.impl.RideServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ReloadDriverHistory implements Commend {
    final private RideServiceImpl rideService = new RideServiceImpl();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        HttpSession session = httpServletRequest.getSession();
        Driver driver = (Driver) session.getAttribute("driver");
        List<Ride> rides = rideService.selectAll();
        List<Ride> ridesDriverHistory = rideService.selectAllByDriverId(driver.getId());
        session.setAttribute("rides", rides);
        session.setAttribute("ridesDriverHistory", ridesDriverHistory);
        return new Page("/pages/driver/orderListDriver.jsp", true, "Success!");
    }
}
