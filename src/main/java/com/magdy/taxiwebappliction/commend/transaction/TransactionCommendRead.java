package com.magdy.taxiwebappliction.commend.transaction;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.service.OrderServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.TransactionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class TransactionCommendRead implements Commend {
    private static final Logger logger = Logger.getLogger(TransactionCommendRead.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        TransactionServiceImpl transactionService = new TransactionServiceImpl();
        Transaction transaction = new Transaction();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            transaction = transactionService.selectById(id);
            logger.info("reade" + transaction);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
