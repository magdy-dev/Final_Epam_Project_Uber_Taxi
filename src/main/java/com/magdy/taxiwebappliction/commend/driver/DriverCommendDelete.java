package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.DriverService;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.util.logging.Logger;

public class DriverCommendDelete implements Commend {
    private DriverService driverService = new DriverService();
    private static final Logger logger = Logger.getLogger(DriverCommendDelete.class.getName());
    private Driver driver = new Driver();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServerException {
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean driver = driverService.deleteById(id);
            logger.info("delete" + driver);
        } catch (ServiceException e) {
            throw new ServerException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
