package com.magdy.taxiwebappliction.commend;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.AddressService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressCommendCreateTest {

    @Test
    public void execute() throws ServiceException {
        AddressService addressService=new AddressService();
        Address address= new Address();
        address.setTown("minsk");
        address.setStreet("ma");
        address.setBuilding(12);
        address=addressService.save(address);
        Address expected=addressService.selectById(address.getId());

        Assert.assertEquals(address,expected);
    }
}