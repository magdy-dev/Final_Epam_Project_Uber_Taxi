package com.magdy.taxiwebappliction.commend.transaction;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.dao.impl.TransactionDaoImpl;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class TransactionCommendCreate implements Commend {
    private static final Logger logger = Logger.getLogger(TransactionCommendCreate.class.getName());

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
            orderService.save(order);

            transaction.setOrder(order);
            transaction.setAmount(233.3);
            transaction.setCash(true);
            transactionService.save(transaction);

            logger.info("create" + transaction);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());

        }

        return new Page("/home.jsp", true, "Success!");
    }
}
