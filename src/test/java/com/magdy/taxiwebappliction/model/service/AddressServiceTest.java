package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.model.dao.empl.AddressDao;
import org.junit.Assert;
import org.junit.Test;

public class AddressServiceTest {

    @Test
    public void save() throws DaoException {
        Address actually = new Address();
        actually.setTown("riga");
        actually.setStreet("minsk");
        actually.setBuilding(3);
        AddressDao addressDao = new AddressDao();
        addressDao.save(actually);
        Address expected = addressDao.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        addressDao.deleteById(actually.getId());
    }

    @Test
    public void saveAll() throws DaoException {
        Address actually = new Address();
        actually.setTown("riga");
        actually.setStreet("bedi");
        actually.setBuilding(5);

        AddressDao addressDao = new AddressDao();
        addressDao.save(actually);
        Address expected = addressDao.selectById(actually.getId());

        Assert.assertEquals(expected, actually);
        addressDao.deleteById(actually.getId());

    }


    @Test
    public void update() throws DaoException {
        Address actually = new Address();
        actually.setTown("r11");
        actually.setStreet("minsk11");
        actually.setBuilding(31);

        AddressDao addressDao = new AddressDao();

        addressDao.save(actually);

        Address address = addressDao.selectById(actually.getId());

        address.setTown("r22");
        address.setStreet("mk22");
        address.setBuilding(47);

        addressDao.update(address);

        Address expected = addressDao.selectById(actually.getId());
        Assert.assertEquals(expected, address);
    }

    @Test
    public void deleteById() throws DaoException {
        Address actually = new Address();
        actually.setId(3);
        actually.setTown("riga");
        actually.setStreet("bedi");
        actually.setBuilding(5);

        AddressDao addressDao = new AddressDao();
        addressDao.save(actually);

        Address expectedAddress = addressDao.selectById(actually.getId());

        Assert.assertEquals(actually, expectedAddress);
        addressDao.deleteById(actually.getId());

        Address expected = addressDao.selectById(actually.getId());

        Assert.assertNull(expected);

    }
}