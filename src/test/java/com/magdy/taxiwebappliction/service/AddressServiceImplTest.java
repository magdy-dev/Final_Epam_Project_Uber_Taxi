package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.AddressDaoImpl;
import org.junit.Assert;
import org.junit.Test;

public class AddressServiceImplTest {

    @Test
    public void save() throws DaoException {
        Address actually = new Address();
        actually.setTown("riga");
        actually.setStreet("minsk");
        actually.setBuilding(3);
        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        addressDaoImpl.save(actually);
        Address expected = addressDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        addressDaoImpl.deleteById(actually.getId());
    }

    @Test
    public void saveAll() throws DaoException {
        Address actually = new Address();
        actually.setTown("riga");
        actually.setStreet("bedi");
        actually.setBuilding(5);

        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        addressDaoImpl.save(actually);
        Address expected = addressDaoImpl.selectById(actually.getId());

        Assert.assertEquals(expected, actually);
        addressDaoImpl.deleteById(actually.getId());

    }


    @Test
    public void update() throws DaoException {
        Address actually = new Address();
        actually.setTown("r11");
        actually.setStreet("minsk11");
        actually.setBuilding(31);

        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();

        addressDaoImpl.save(actually);

        Address address = addressDaoImpl.selectById(actually.getId());

        address.setTown("r22");
        address.setStreet("mk22");
        address.setBuilding(47);

        addressDaoImpl.update(address);

        Address expected = addressDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, address);
    }

    @Test
    public void deleteById() throws DaoException {
        Address actually = new Address();
        actually.setId(3);
        actually.setTown("riga");
        actually.setStreet("bedi");
        actually.setBuilding(5);

        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        addressDaoImpl.save(actually);

        Address expectedAddress = addressDaoImpl.selectById(actually.getId());

        Assert.assertEquals(actually, expectedAddress);
        addressDaoImpl.deleteById(actually.getId());

        Address expected = addressDaoImpl.selectById(actually.getId());

        Assert.assertNull(expected);

    }
}