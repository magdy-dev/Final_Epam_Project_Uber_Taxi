package com.magdy.taxiwebappliction.commend.addresscommend;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class AddressCommendUpdate implements Commend {

    private static final Logger logger = Logger.getLogger(AddressCommendUpdate.class.getName());

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        Address address = new Address();
        AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

        try {
            address.setTown(httpServletRequest.getParameter("town"));
            address.setStreet(httpServletRequest.getParameter("street"));
            address.setBuilding(2);
            address = addressServiceImpl.update(address);
            logger.info("update" + address);

        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
