package com.magdy.taxiwebappliction.commend.addresscommend;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class AddressCommendRead implements Commend {

    private static final Logger logger = Logger.getLogger(AddressCommendRead.class.getName());

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {
        AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
        Address address = new Address();

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            address = addressServiceImpl.selectById(id);
            logger.info("reade" + address);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp", true, "Success!");
    }
}
