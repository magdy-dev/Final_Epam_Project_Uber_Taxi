package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class DriverCommendCreate implements Commend {

    private static final Logger log= (Logger) LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
        Driver driver = new Driver();
        try {
            driver.setName(httpServletRequest.getParameter("name"));
            driver.setLastName(httpServletRequest.getParameter("lastName"));
            driver.setEmail(httpServletRequest.getParameter("email"));
            driver.setPassword(httpServletRequest.getParameter("password"));
            driver.setPhoneNumber(httpServletRequest.getParameter("phoneNumber"));
            driver.setCarNumber(httpServletRequest.getParameter("carNumber"));
            driver = driverServiceImpl.save(driver);
            log.info("creat" + driver);

        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }

        return new Page("/home.jsp", true, "Success!");
    }
}
