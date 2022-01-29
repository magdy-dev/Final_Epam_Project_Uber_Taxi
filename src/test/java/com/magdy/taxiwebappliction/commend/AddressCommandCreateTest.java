package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.service.ServiceException;
import com.magdy.taxiwebappliction.service.impl.AddressServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class AddressCommandCreateTest {

    @Test
    public void execute() throws ServiceException {
        AddressServiceImpl addressServiceImpl =new AddressServiceImpl();
        Address address= new Address();
        address.setTown("minsk");
        address.setStreet("ma");
        address.setBuilding(12);
        address= addressServiceImpl.save(address);
        Address expected= addressServiceImpl.selectById(address.getId());

        Assert.assertEquals(address,expected);
    }
}