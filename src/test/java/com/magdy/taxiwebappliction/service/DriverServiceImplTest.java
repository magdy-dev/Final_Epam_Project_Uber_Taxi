package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import org.junit.Assert;
import org.junit.Test;

public class DriverServiceImplTest {

    @Test
    public void save() throws DaoException {
        Driver actually = new Driver();
        actually.setName("mkmkm");
        actually.setLastName("jjjjj");
        actually.setCarNumber("22222");
        actually.setEmail("sdssf11111@ad@dag334ddc1111");
        actually.setPassword("32222222222222");
        actually.setPhoneNumber("1223444");
        DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
        driverDaoImpl.save(actually);
        Driver expected = driverDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        driverDaoImpl.deleteById(actually.getId());
    }


    @Test
    public void selectById() throws DaoException {

        Driver actually = new Driver();
        actually.setName("m2");
        actually.setLastName("j33");
        actually.setCarNumber("222");
        actually.setEmail("s@@1w1w");
        actually.setPassword("2222222222");
        actually.setPhoneNumber("1223444");

        DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
        driverDaoImpl.save(actually);
        Driver expected = driverDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        driverDaoImpl.deleteById(actually.getId());

    }


    @Test
    public void update() throws DaoException {
        Driver actually = new Driver();
        actually.setName("m2");
        actually.setLastName("j33");
        actually.setCarNumber("222");
        actually.setEmail("s@@11www@");
        actually.setPassword("2222ssk222222");
        actually.setPhoneNumber("1223444");
        DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
        driverDaoImpl.save(actually);
        Driver driver = driverDaoImpl.selectById(actually.getId());
        driver.setName("m2");
        driver.setLastName("j33");
        driver.setCarNumber("222");
        driver.setEmail("s@1w1w1w1ww@@");
        driver.setPassword("2222ssk222222");
        driver.setPhoneNumber("1223444");
        driverDaoImpl.update(driver);
        Driver expected = driverDaoImpl.selectById(driver.getId());
        Assert.assertEquals(expected, driver);
    }

    @Test
    public void deleteById() throws DaoException {
        Driver actually = new Driver();
        actually.setName("m2");
        actually.setLastName("j33");
        actually.setCarNumber("222");
        actually.setEmail("s1wwwww1qwas@@@22");
        actually.setPassword("2222ssk222222");
        actually.setPhoneNumber("1223444");
        DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
        driverDaoImpl.save(actually);


        Driver driver = driverDaoImpl.selectById(actually.getId());


        Assert.assertEquals(driver, actually);

        driverDaoImpl.deleteById(actually.getId());

        Driver expected = driverDaoImpl.selectById(actually.getId());

        Assert.assertNull(expected);

    }
}