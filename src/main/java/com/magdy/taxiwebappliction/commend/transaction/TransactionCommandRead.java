package com.magdy.taxiwebappliction.commend.transaction;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.entity.Transaction;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.TransactionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class TransactionCommandRead implements Command {
    private static final Logger log= (Logger) LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        TransactionServiceImpl transactionService = new TransactionServiceImpl();
        Transaction transaction = new Transaction();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            transaction = transactionService.selectById(id);
            log.info("reade" + transaction);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
