package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.AddressDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.OrderDaoImpl;
import com.magdy.taxiwebappliction.service.impl.AddressServiceImpl;
import com.magdy.taxiwebappliction.service.impl.OrderServiceImpl;
import com.magdy.taxiwebappliction.service.impl.RideServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RideServiceTest {



    private Ride ride =new Ride();
    private AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
    private RideServiceImpl rideService =new RideServiceImpl();
    private Address address1=new Address();
    private Address address2=new Address();
    private Order order = new Order();
    private Client client = new Client();
    private Driver driver = new Driver();
    private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    private AddressServiceImpl addressServiceImpl =new AddressServiceImpl();
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    @Before
    public void init() throws DaoException, ServiceException {
        driver.setName("magdy");
        driver.setLastName("shenoda");
        driver.setCarNumber("2222");
        driver.setEmail("x111adrdsiver-Test@gmail.com");
        driver.setPassword("11111");
        driver.setPhoneNumber("+1223444");
        driverDaoImpl.save(driver);

        client.setName("mina");
        client.setLastName("shenoda");
        client.setEmail("a1qa1cslient-Test@gmail.com");
        client.setPassword("3456789");
        client.setPhoneNumber("1222222");
        clientDaoImpl.save(client);

        address1.setTown("minsk");
        address1.setStreet("yakobakolasa");
        address1.setBuilding(22);
        addressServiceImpl.save(address1);

        address2.setTown("minsk");
        address2.setStreet("patrofshena");
        address2.setBuilding(2);
        addressServiceImpl.save(address2);

        order.setData("12/22");
        order.setDriver(driver);
        order.setClient(client);
        orderServiceImpl.save(order);


    }

    @After
    public void dst() throws ServiceException, DaoException {
        rideService.deleteById(ride.getId());
        addressDaoImpl.deleteById(address1.getId());
        addressDaoImpl.deleteById(address2.getId());
        orderDaoImpl.deleteById(order.getId());
        clientDaoImpl.deleteById(client.getId());
        driverDaoImpl.deleteById(driver.getId());
    }

    @Test
    public void save() throws ServiceException {

       Ride ride = new Ride(address1,address2,order);
        Ride actually =rideService.save(ride);
        Ride expected =rideService.selectById(ride.getId());
        Assert.assertEquals(expected,actually);





    }



}