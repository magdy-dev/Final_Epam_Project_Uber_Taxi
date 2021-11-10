package com.magdy.taxiwebappliction.model.service;


import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.ClientDao;
import com.magdy.taxiwebappliction.model.dao.empl.DriverDao;
import com.magdy.taxiwebappliction.model.dao.empl.OrderDao;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {

    private Order order = new Order();
    private Client client = new Client();
    private Driver driver = new Driver();
    private ClientDao clientDao = new ClientDao();
    private DriverDao driverDao = new DriverDao();
    private OrderService orderService = new OrderService();
    private OrderDao orderDao = new OrderDao();

    @Before
    public void init() throws DaoException {
        driver.setName("magdy");
        driver.setLastName("shenoda");
        driver.setCarNumber("2222");
        driver.setEmail("11adriver-Test@gmail.com");
        driver.setPassword("11111");
        driver.setPhoneNumber("+1223444");
        driverDao.save(driver);


        client.setName("mina");
        client.setLastName("shenoda");
        client.setEmail("1a1client-Test@gmail.com");
        client.setPassword("3456789");
        client.setPhoneNumber("1222222");
        clientDao.save(client);

    }

    @After
    public void dst() throws ServiceException, DaoException {
        orderService.deleteById(order.getId());
        clientDao.deleteById(client.getId());
        driverDao.deleteById(driver.getId());
    }


    @Test
    public void save() throws ServiceException {

        order = new Order("3/12", client, driver);
        Order actually = orderService.save(order);
        Order expected = orderService.selectById(actually.getId());
        Assert.assertEquals(expected, actually);

    }


    @Test
    public void selectById() throws ServiceException {
        order = new Order("3/12", client, driver);
        Order actually = orderService.save(order);
        Order expected = orderService.selectById(actually.getId());
        Assert.assertEquals(expected, actually);

    }



    @Test
    public void update() throws ServiceException {



    }

    @Test
    public void deleteById() throws ServiceException {
        order = new Order("14/12", client, driver);
        Order actually = orderService.save(order);

        Order expected = orderService.selectById(actually.getId());

        Assert.assertEquals(expected, actually);






    }
}