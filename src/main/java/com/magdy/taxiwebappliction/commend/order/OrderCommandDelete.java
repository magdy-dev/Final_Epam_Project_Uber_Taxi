package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class OrderCommandDelete implements Command {

    private static final Logger log= (Logger) LogManager.getLogger();

    private final OrderServiceImpl orderService = new OrderServiceImpl();
    private final Order order = new Order();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean order = orderService.deleteById(id);
            log.info("delete" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}

