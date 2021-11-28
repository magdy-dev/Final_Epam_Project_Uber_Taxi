package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class DriverCommendRead implements Commend {

    private static final Logger logger = Logger.getLogger(DriverCommendRead.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
        Driver driver = new Driver();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            driver = driverServiceImpl.selectById(id);
            logger.info("reade" + driver);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

        return new Page("/home.jsp", true, "Success!");
    }
}
