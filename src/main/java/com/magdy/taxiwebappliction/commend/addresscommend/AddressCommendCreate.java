package com.magdy.taxiwebappliction.commend.addresscommend;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class AddressCommendCreate implements Commend {

    private static final Logger logger = Logger.getLogger(AddressCommendCreate.class.getName());


    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException{
        AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
        Address address = new Address();
        try {
            address.setTown("town");
            address.setStreet("street");
            address.setBuilding(2);
            address= addressServiceImpl.save(address);
            logger.info("creat"+address);

        } catch (ServiceException e) {
           throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp",true,"Success!");
    }
}
