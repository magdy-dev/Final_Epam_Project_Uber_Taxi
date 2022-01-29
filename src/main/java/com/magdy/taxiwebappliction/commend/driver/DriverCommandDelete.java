package com.magdy.taxiwebappliction.commend.driver;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

public class DriverCommandDelete implements Command {
    private DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
    private static final Logger logger = Logger.getLogger(DriverCommandDelete.class.getName());

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

            long id = Long.parseLong(httpServletRequest.getParameter("driverId"));
            boolean driver = driverServiceImpl.deleteById(id);
            List<Driver> driverList = driverServiceImpl.selectAll();
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("driverList", driverList);

            return new Page("/pages/owner/ownerDriverPage.jsp", true, "Success!");

        }
}
