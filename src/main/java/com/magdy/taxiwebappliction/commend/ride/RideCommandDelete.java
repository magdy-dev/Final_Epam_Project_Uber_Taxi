package com.magdy.taxiwebappliction.commend.ride;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.RideServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class RideCommandDelete implements Command {
    private static final Logger log= (Logger) LogManager.getLogger();
    private RideServiceImpl rideService = new RideServiceImpl();
    private Ride ride = new Ride();


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean address = rideService.deleteById(id);
            log.info("delete" + ride);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}

