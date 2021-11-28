package com.magdy.taxiwebappliction.commend.transaction;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.ClientServiceImpl;
import com.magdy.taxiwebappliction.service.impl.DriverServiceImpl;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import com.magdy.taxiwebappliction.service.impl.TransactionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class TransactionCommendUpdate implements Commend {

    private static final Logger logger = Logger.getLogger(TransactionCommendUpdate.class.getName());

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        DriverServiceImpl driverService = new DriverServiceImpl();
        Driver driver = new Driver();
        ClientServiceImpl clientService = new ClientServiceImpl();
        Client client = new Client();
        TransactionServiceImpl transactionService = new TransactionServiceImpl();
        Transaction transaction = new Transaction();

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
            orderService.save(order);

            transaction.setOrder(order);
            transaction.setAmount(233.3);
            transaction.setCash(true);
            transactionService.update(transaction);

            logger.info("update" + transaction);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());

        }

        return new Page("/home.jsp", true, "Success!");
    }

}
