package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class OrderCommandRead implements Command {
    private static final Logger log= (Logger) LogManager.getLogger();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = new Order();
        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            order = orderService.selectById(id);
            log.info("reade" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
