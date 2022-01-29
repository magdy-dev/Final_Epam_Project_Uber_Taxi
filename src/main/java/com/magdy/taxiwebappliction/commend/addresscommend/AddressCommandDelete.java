package com.magdy.taxiwebappliction.commend.addresscommend;

import com.magdy.taxiwebappliction.commend.Command;
import com.magdy.taxiwebappliction.commend.Page;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.AddressServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddressCommandDelete implements Command {

    private final AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    private static final Logger log= (Logger) LogManager.getLogger();
    @Override
    public Page execute(HttpServletRequest httpServletRequest) throws ServiceException {

        try {
            long id = Long.parseLong(httpServletRequest.getParameter("id"));
            boolean address = addressServiceImpl.deleteById(id);
            log.info("delete" + address);
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
        return new Page("/home.jsp",true,"Success!");
    }
}
