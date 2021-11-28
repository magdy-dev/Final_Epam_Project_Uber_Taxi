package com.magdy.taxiwebappliction.commend.addresscommend;

import com.magdy.taxiwebappliction.commend.Commend;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.AddressServiceImpl;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class AddressCommendDelete implements Commend {

    private AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    private Address address = new Address();
    private static final Logger logger = Logger.getLogger(AddressCommendDelete.class.getName());

    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean address = addressServiceImpl.deleteById(id);
            logger.info("delete" + address);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp",true,"Success!");
    }
}
