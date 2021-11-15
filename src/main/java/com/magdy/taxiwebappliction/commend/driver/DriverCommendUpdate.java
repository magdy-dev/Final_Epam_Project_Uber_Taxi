package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.DriverServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class DriverCommendUpdate implements Commend {


    private static final Logger logger = Logger.getLogger(DriverCommendUpdate.class.getName());

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
        Driver driver = new Driver();
        try {
            driver.setName("name");
            driver.setLastName("lastName");
            driver.setEmail("email");
            driver.setPassword("password");
            driver.setPhoneNumber("phoneNumber");
            driver.setCarNumber("carNumber");
            driver = driverServiceImpl.update(driver);
            logger.info("creat" + driver);
        } catch (
                ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
