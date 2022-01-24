package com.magdy.taxiwebappliction.commend.ride;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendRead;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.service.impl.RideServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class RideCommendRead implements Commend {
    private static final Logger log= (Logger) LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        RideServiceImpl rideService = new RideServiceImpl();
        Ride ride = new Ride();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            ride = rideService.selectById(id);
            log.info("reade" + ride);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
