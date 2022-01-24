package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class DriverCommendRead implements Commend {

    private static final Logger log= (Logger) LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
        Driver driver ;
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            driver = driverServiceImpl.selectById(id);
            log.info("reade" + driver);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

        return new Page("/home.jsp", true, "Success!");
    }
}
