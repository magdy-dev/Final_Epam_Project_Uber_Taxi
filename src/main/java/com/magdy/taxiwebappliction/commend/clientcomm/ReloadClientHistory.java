package com.magdy.taxiwebappliction.commend.clientcomm;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Ride;
import com.magdy.taxiwebappliction.service.RideServiceImpl;
import com.magdy.taxiwebappliction.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ReloadClientHistory implements Commend {
    private RideServiceImpl rideService = new RideServiceImpl();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        HttpSession session = httpServletRequest.getSession();
        Client client = (Client) session.getAttribute("client");
        List<Ride> ridesClientHistory = rideService.selectAllByClientId(client.getId());
        session.setAttribute("ridesClientHistory", ridesClientHistory);
        return new Page("/pages/client/orderListClient.jsp", true, "Success!");
    }
}
