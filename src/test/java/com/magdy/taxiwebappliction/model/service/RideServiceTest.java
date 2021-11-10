package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.AddressDao;
import com.magdy.taxiwebappliction.model.dao.empl.ClientDao;
import com.magdy.taxiwebappliction.model.dao.empl.DriverDao;
import com.magdy.taxiwebappliction.model.dao.empl.OrderDao;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RideServiceTest {



    private Ride ride =new Ride();
    private AddressDao addressDao = new AddressDao();
    private RideService rideService =new RideService();
    private Address address1=new Address();
    private Address address2=new Address();
    private Order order = new Order();
    private Client client = new Client();
    private Driver driver = new Driver();
    private ClientDao clientDao = new ClientDao();
    private DriverDao driverDao = new DriverDao();
    private OrderService orderService = new OrderService();
    private AddressService addressService=new AddressService();
    private OrderDao orderDao = new OrderDao();

    @Before
    public void init() throws DaoException, ServiceException {
        driver.setName("magdy");
        driver.setLastName("shenoda");
        driver.setCarNumber("2222");
        driver.setEmail("x111adrdsiver-Test@gmail.com");
        driver.setPassword("11111");
        driver.setPhoneNumber("+1223444");
        driverDao.save(driver);

        client.setName("mina");
        client.setLastName("shenoda");
        client.setEmail("a1qa1cslient-Test@gmail.com");
        client.setPassword("3456789");
        client.setPhoneNumber("1222222");
        clientDao.save(client);

        address1.setTown("minsk");
        address1.setStreet("yakobakolasa");
        address1.setBuilding(22);
        addressService.save(address1);

        address2.setTown("minsk");
        address2.setStreet("patrofshena");
        address2.setBuilding(2);
        addressService.save(address2);

        order.setData("12/22");
        order.setDriver(driver);
        order.setClient(client);
        orderService.save(order);


    }

    @After
    public void dst() throws ServiceException, DaoException {
        rideService.deleteById(ride.getId());
        addressDao.deleteById(address1.getId());
        addressDao.deleteById(address2.getId());
        orderDao.deleteById(order.getId());
        clientDao.deleteById(client.getId());
        driverDao.deleteById(driver.getId());
    }

    @Test
    public void save() throws ServiceException {

       Ride ride = new Ride(address1,address2,order);
        Ride actually =rideService.save(ride);
        Ride expected =rideService.selectById(ride.getId());
        Assert.assertEquals(expected,actually);





    }

    @Test
    public void saveAll() {
    }

    @Test
    public void selectById() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}