package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import org.junit.Assert;
import org.junit.Test;

public class ClientServiceImplTest {

    @Test
    public void save() throws DaoException {
        Client actually = new Client();
        actually.setName("magdy");
        actually.setLastName("shenoda");
        actually.setEmail("asdfdd@xaaaasx");
        actually.setPassword("1234");
        actually.setPhoneNumber("12345");
        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
        clientDaoImpl.save(actually);
        Client expected = clientDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
    }


    @Test
    public void selectById() throws DaoException {
        Client actually = new Client();
        actually.setId(1);
        actually.setName("magdy");
        actually.setLastName("shenoda");
        actually.setEmail("asd2d@x");
        actually.setPassword("1234");
        actually.setPhoneNumber("12345");

        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
        clientDaoImpl.save(actually);
        Client expected = clientDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        clientDaoImpl.deleteById(actually.getId());
    }


    @Test
    public void update() throws DaoException {
        Client actually = new Client();
        actually.setName("magdy");
        actually.setLastName("shenoda");
        actually.setEmail("asdfsssdx.xd@x1212");
        actually.setPassword("1234");
        actually.setPhoneNumber("12345");
        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();

        clientDaoImpl.save(actually);

        Client client = clientDaoImpl.selectById(actually.getId());

        client.setName("magdy111");
        client.setLastName("shsjienoda");
        client.setEmail("asdfsssdd@x11123331");
        client.setPassword("1234111");
        client.setPhoneNumber("1234511");

        clientDaoImpl.update(client);


        Client expected = clientDaoImpl.selectById(actually.getId());
        Assert.assertEquals(expected, client);
    }

    @Test
    public void deleteById() throws DaoException {
        Client actually = new Client();
        actually.setId(2);
        actually.setName("magdy");
        actually.setLastName("shenoda");
        actually.setEmail("asdfdddsa@x");
        actually.setPassword("1234");
        actually.setPhoneNumber("12345");

        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
        clientDaoImpl.save(actually);

        Client expectedClient = clientDaoImpl.selectById(actually.getId());

        Assert.assertEquals(expectedClient, actually);

        clientDaoImpl.deleteById(actually.getId());

        Client expected = clientDaoImpl.selectById(actually.getId());

        Assert.assertNull(expected);
    }
}