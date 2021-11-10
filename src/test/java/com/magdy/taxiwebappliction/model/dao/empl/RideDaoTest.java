package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.*;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.service.AddressService;
import com.magdy.taxiwebappliction.model.service.OrderService;
import com.magdy.taxiwebappliction.model.service.RideService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RideDaoTest {

    private Ride ride =new Ride();
    private AddressDao addressDao = new AddressDao();
    private RideDao  rideDao =new RideDao();
    private Address address1=new Address();
    private Address address2=new Address();
    private Order order = new Order();
    private Client client = new Client();
    private Driver driver = new Driver();
    private ClientDao clientDao = new ClientDao();
    private DriverDao driverDao = new DriverDao();
    private OrderDao orderDao = new OrderDao();
    private RideService rideService = new RideService();
    private OrderService orderService= new OrderService();

    @Before
    public void init() throws DaoException, ServiceException {
        driver.setName("magdy");
        driver.setLastName("shenoda");
        driver.setCarNumber("2222");
        driver.setEmail("12m@x@nxx1zz.com");
        driver.setPassword("11111");
        driver.setPhoneNumber("+1223444");
        driverDao.save(driver);

        client.setName("mina");
        client.setLastName("shenoda");
        client.setEmail("1m3kx kxz@mzzz@zkmxnxzux11.com");
        client.setPassword("3456789");
        client.setPhoneNumber("1222222");
        clientDao.save(client);

        address1.setTown("minsk");
        address1.setStreet("yakobakolasa");
        address1.setBuilding(22);
        addressDao.save(address1);

        address2.setTown("minsk");
        address2.setStreet("patrofshena");
        address2.setBuilding(2);
        addressDao.save(address2);

        order.setData("12/22");
        order.setDriver(driver);
        order.setClient(client);
        orderService.save(order);


    }

    @After
    public void dst() throws  ServiceException {
        rideService.deleteById(ride.getId());

    }

    @Test
    public void save() throws DaoException, ServiceException {
        ride =new Ride(address1,address2,order);
        ride=rideService.save(ride);
        Ride expected = rideService.selectById(ride.getId());
        Assert.assertEquals(expected,ride);

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