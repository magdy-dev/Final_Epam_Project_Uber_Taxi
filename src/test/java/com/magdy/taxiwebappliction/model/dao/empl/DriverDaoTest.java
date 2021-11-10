package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.exception.DaoException;
import org.junit.Assert;
import org.junit.Test;

public class DriverDaoTest {

    @Test
    public void save() throws DaoException {
        Driver actually = new Driver();
        actually.setName("mkmkm");
        actually.setLastName("jjjjj");
        actually.setCarNumber("22222");
        actually.setEmail("sdssf11111@ad@dag334ddc");
        actually.setPassword("32222222222222");
        actually.setPhoneNumber("1223444");
        DriverDao driverDao = new DriverDao();
        driverDao.save(actually);
        Driver expected = driverDao.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        driverDao.deleteById(actually.getId());

    }


    @Test
    public void selectById() throws DaoException {
        Driver actually = new Driver();
        actually.setName("m2");
        actually.setLastName("j33");
        actually.setCarNumber("222");
        actually.setEmail("s@@");
        actually.setPassword("2222222222");
        actually.setPhoneNumber("1223444");

        DriverDao driverDao = new DriverDao();
        driverDao.save(actually);
        Driver expected = driverDao.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        driverDao.deleteById(actually.getId());

    }


    @Test
    public void update() throws DaoException {

        Driver actually = new Driver();
        actually.setName("m2");
        actually.setLastName("j33");
        actually.setCarNumber("222");
        actually.setEmail("s@@3@");
        actually.setPassword("2222ssk222222");
        actually.setPhoneNumber("1223444");
        DriverDao driverDao = new DriverDao();
        driverDao.save(actually);

        Driver driver = driverDao.selectById(actually.getId());
        driver.setName("m2");
        driver.setLastName("j33");
        driver.setCarNumber("222");
        driver.setEmail("s@@@");
        driver.setPassword("2222ssk222222");
        driver.setPhoneNumber("1223444");
        driverDao.update(driver);
        Driver expected = driverDao.selectById(driver.getId());
        Assert.assertEquals(expected, driver);

    }

    @Test
    public void deleteById() throws DaoException {
        Driver actually = new Driver();
        actually.setName("m2");
        actually.setLastName("j33");
        actually.setCarNumber("222");
        actually.setEmail("s@x@@22");
        actually.setPassword("2222ssk222222");
        actually.setPhoneNumber("1223444");
        DriverDao driverDao = new DriverDao();
        driverDao.save(actually);


        Driver driver = driverDao.selectById(actually.getId());


        Assert.assertEquals(driver, actually);

        driverDao.deleteById(actually.getId());

        Driver expected = driverDao.selectById(actually.getId());

        Assert.assertNull(expected);


    }
}