package com.magdy.taxiwebappliction.commend.addresscommend;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.AddressService;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
import java.util.logging.Logger;

public class AddressCommendUpdate implements Commend {
    private AddressService addressService = new AddressService();
    private static final Logger logger = Logger.getLogger(AddressCommendUpdate.class.getName());
    private Address address = new Address();

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            address.setTown("town");
            address.setStreet("street");
            address.setBuilding(2);
            address=addressService.update(address);
            logger.info("update"+address);

        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp",true,"Success!");
    }
}
