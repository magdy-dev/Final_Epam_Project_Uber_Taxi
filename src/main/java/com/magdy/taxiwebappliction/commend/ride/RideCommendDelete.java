package com.magdy.taxiwebappliction.commend.ride;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendDelete;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendRead;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class RideCommendDelete implements Commend {

    private static final Logger logger = Logger.getLogger(ClientCommendDelete.class.getName());
    private RideServiceImpl rideService = new RideServiceImpl();
    private Ride ride = new Ride();


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean address = rideService.deleteById(id);
            logger.info("delete" + ride);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}

