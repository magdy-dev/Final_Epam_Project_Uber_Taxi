package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class OrderCommendDelete implements Commend {

    private static final Logger logger = Logger.getLogger(OrderCommendDelete.class.getName());
    private OrderServiceImpl orderService = new OrderServiceImpl();
    private Order order = new Order();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean order = orderService.deleteById(id);
            logger.info("delete" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}

