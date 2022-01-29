package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.ClientServiceImpl;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class OrderCommandUpdate implements Command {

    private static final Logger log= (Logger) LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        DriverServiceImpl driverService = new DriverServiceImpl();
        Driver driver = new Driver();
        ClientServiceImpl clientService = new ClientServiceImpl();
        Client client = new Client();
        try {

            driver.setName(httpServletRequest.getParameter("magdy"));
            driver.setLastName(httpServletRequest.getParameter("shenoda"));
            driver.setEmail(httpServletRequest.getParameter("amamama@.gmail.com"));
            driver.setPassword(httpServletRequest.getParameter("12345"));
            driver.setCarNumber(httpServletRequest.getParameter("122333bb"));
            driver.setPhoneNumber(httpServletRequest.getParameter("123344333"));
            clientService.save(client);

            client.setName(httpServletRequest.getParameter("magdyaa"));
            client.setLastName(httpServletRequest.getParameter("shenoda"));
            client.setEmail(httpServletRequest.getParameter("111amamama@.gmail.com"));
            client.setPassword(httpServletRequest.getParameter("12345"));
            client.setPhoneNumber(httpServletRequest.getParameter("+122333bb"));
            clientService.save(client);

            order.setData(httpServletRequest.getParameter("22.22"));
            order.setDriver(driver);
            order.setClient(client);
            orderService.update(order);


            log.info("order" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());

        }

        return new Page("/home.jsp", true, "Success!");
    }

}
