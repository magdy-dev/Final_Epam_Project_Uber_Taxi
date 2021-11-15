package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.commend.clientcomm.ClientCommendUpdate;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class OrderCommendUpdate implements Commend {

    private static final Logger logger = Logger.getLogger(OrderCommendUpdate.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        DriverServiceImpl driverService = new DriverServiceImpl();
        Driver driver = new Driver();
        ClientServiceImpl clientService = new ClientServiceImpl();
        Client client = new Client();
        try {

            driver.setName("magdy");
            driver.setLastName("shenoda");
            driver.setEmail("amamama@.gmail.com");
            driver.setPassword("12345");
            driver.setCarNumber("122333bb");
            driver.setPhoneNumber("123344333");
            clientService.save(client);

            client.setName("magdyaa");
            client.setLastName("shenoda");
            client.setEmail("111amamama@.gmail.com");
            client.setPassword("12345");
            client.setPhoneNumber("+122333bb");
            clientService.save(client);

            order.setData("22.22");
            order.setDriver(driver);
            order.setClient(client);
            orderService.update(order);


            logger.info("order" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());

        }

        return new Page("/home.jsp", true, "Success!");
    }

}
