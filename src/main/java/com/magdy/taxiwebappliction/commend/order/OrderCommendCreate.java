package com.magdy.taxiwebappliction.commend.order;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.service.*;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import com.magdy.taxiwebappliction.service.impl.RideServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class OrderCommendCreate implements Commend {
    private static final Logger log= (Logger) LogManager.getLogger();

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
            String[] isCash = httpServletRequest.getParameterValues("isCash");
            if (isCash != null && isCash.length > 0){
                session.setAttribute("isCash", isCash[0]);
            }else {
                session.setAttribute("isCash", "card");
            }
            session.setAttribute("from",fromTown + "-" + fromStreet);
            session.setAttribute("to",toTown + "-" + toStreet);
            session.setAttribute("message","Order Success!");
            log.info("create" + order);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());

        }

        return new Page("/pages/client/orderClient.jsp", true, "Success!");
    }
}
