package com.magdy.taxiwebappliction.model.dao.empl;


import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.model.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderDaoTest {

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
        driver.setEmail("11dzxskskzzjzzazzxxxrmzziver-Test@gmail.com");
        driver.setPassword("11111");
        driver.setPhoneNumber("+1223444");
        driverDao.save(driver);


        client.setName("mina");
        client.setLastName("shenoda");
        client.setEmail("11clhlxazilszzzxxzxezmzzznt-Test@gmail.com");
        client.setPassword("3456789");
        client.setPhoneNumber("1222222");
        clientDao.save(client);

    }

//    @After
//    public void dst() throws ServiceException, DaoException {
//        orderService.deleteById(order.getId());
//        clientDao.deleteById(client.getId());
//        driverDao.deleteById(driver.getId());
//    }

    @Test
    public void save() throws ServiceException {

        order = new Order("12", client, driver);
        order=orderService.save(order);
        Order expected = orderService.selectById(order.getId());
        Assert.assertEquals(expected, order);

    }

    @Test
    public void selectById() throws ServiceException, DaoException {
        order = new Order("", client, driver);
        order = orderService.save(order);
        Order expected = orderService.selectById(order.getId());
        Assert.assertEquals(expected, order);
    }


    @Test
    public void update() throws ServiceException, DaoException {
        order = new Order("33", client, driver);
        order = orderService.save(order);
        Order actually = orderService.selectById(order.getId());
        actually.setData("22/22");
        actually.setClient(client);
        actually.setDriver(driver);
        orderService.update(actually);
        Order expected = orderService.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void deleteById() throws ServiceException {
        order = new Order("1", client, driver);
        order = orderService.save(order);
        Order expected = orderService.selectById(order.getId());
        Assert.assertEquals(expected, order);
        orderService.deleteById(order.getId());
        order = orderService.selectById(order.getId());
        Assert.assertNull(order);

    }
}