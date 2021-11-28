package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class OrderCommendRead implements Commend {
    private static final Logger logger = Logger.getLogger(OrderCommendRead.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            order = orderService.selectById(id);
            logger.info("reade" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
