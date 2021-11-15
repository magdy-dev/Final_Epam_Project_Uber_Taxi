package com.magdy.taxiwebappliction.commend.ride;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendDelete;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendRead;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.service.RideServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class RideCommendRead implements Commend {
    private static final Logger logger = Logger.getLogger(ClientCommendRead.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        RideServiceImpl rideService = new RideServiceImpl();
        Ride ride = new Ride();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            ride = rideService.selectById(id);
            logger.info("reade" + ride);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
