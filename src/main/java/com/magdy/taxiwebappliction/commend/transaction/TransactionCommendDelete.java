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

public class TransactionCommendDelete implements Commend {

    private static final Logger logger = Logger.getLogger(TransactionCommendDelete.class.getName());
    private OrderServiceImpl orderService = new OrderServiceImpl();
    private Order order = new Order();
    private TransactionServiceImpl transactionService = new TransactionServiceImpl();
    private Transaction transaction = new Transaction();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean transaction = transactionService.deleteById(id);
            logger.info("delete" + transaction);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}

