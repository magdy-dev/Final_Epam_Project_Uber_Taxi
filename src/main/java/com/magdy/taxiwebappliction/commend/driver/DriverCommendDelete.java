package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.DriverServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class DriverCommendDelete implements Commend {
    private DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
    private static final Logger logger = Logger.getLogger(DriverCommendDelete.class.getName());
    private Driver driver = new Driver();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean driver = driverServiceImpl.deleteById(id);
            logger.info("delete" + driver);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
