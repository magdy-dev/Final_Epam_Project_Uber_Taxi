package com.magdy.taxiwebappliction.service;


import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.OrderDaoImpl;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;

import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceImplTest {

    private Order order = new Order();
    private Client client = new Client();
    private Driver driver = new Driver();
    private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    @Before
    public void init() throws DaoException {
        driver.setName("magdy");
        driver.setLastName("shenoda");
        driver.setCarNumber("2222");
        driver.setEmail("11adriver-Test@gmail.com");
        driver.setPassword("11111");
        driver.setPhoneNumber("+1223444");
        driverDaoImpl.save(driver);


        client.setName("mina");
        client.setLastName("shenoda");
        client.setEmail("1a1client-Test@gmail.com");
        client.setPassword("3456789");
        client.setPhoneNumber("1222222");
        clientDaoImpl.save(client);
            int x =0;
    }

    @After
    public void dst() throws ServiceException, DaoException {
        orderServiceImpl.deleteById(order.getId());
        clientDaoImpl.deleteById(client.getId());
        driverDaoImpl.deleteById(driver.getId());
    }


    @Test
    public void save() throws ServiceException {

        order = new Order("3/12", client, driver);
        Order actually = orderServiceImpl.save(order);
        Order expected = orderServiceImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);

    }


    @Test
    public void selectById() throws ServiceException {
        order = new Order("3/12", client, driver);
        Order actually = orderServiceImpl.save(order);
        Order expected = orderServiceImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);

    }



    @Test
    public void update() throws ServiceException {
        order = new Order("33", client, driver);
        order = orderServiceImpl.save(order);
        Order actually = orderServiceImpl.selectById(order.getId());
        actually.setData("22/22");
        actually.setClient(client);
        actually.setDriver(driver);
        orderServiceImpl.update(actually);
        Order expected = orderServiceImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);


    }

    @Test
    public void deleteById() throws ServiceException {
        order = new Order("14/12", client, driver);
        Order actually = orderServiceImpl.save(order);

        Order expected = orderServiceImpl.selectById(actually.getId());

        Assert.assertEquals(expected, actually);






    }
}