package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.logging.Logger;

public class OrderCommendCreate implements Commend {
    private static final Logger logger = Logger.getLogger(OrderCommendCreate.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        RideServiceImpl rideService = new RideServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();
        HttpSession session = httpServletRequest.getSession();
        String fromTown = httpServletRequest.getParameter("from_town");
        String fromStreet = httpServletRequest.getParameter("from_street");

        String toTown = httpServletRequest.getParameter("to_town");
        String toStreet = httpServletRequest.getParameter("to_street");

        Client client = (Client) session.getAttribute("client");

        try {
            Ride ride = new Ride();
            Order order = new Order();
            order.setClient(client);
            order.setData(new Date().toLocaleString());
            order = orderService.save(order);
            ride.setAddressFrom(new Address(fromTown,fromStreet,-1));
            ride.setAddressTo(new Address(toTown,toStreet,-1));
            ride.setOrder(order);
            rideService.save(ride);
            session.setAttribute("isCash",httpServletRequest.getParameterValues("isCash")[0]);
            session.setAttribute("from",fromTown + "-" + fromStreet);
            session.setAttribute("to",toTown + "-" + toStreet);
            session.setAttribute("message","Order Success!");
            logger.info("create" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());

        }

        return new Page("/pages/client/orderClient.jsp", true, "Success!");
    }
}
