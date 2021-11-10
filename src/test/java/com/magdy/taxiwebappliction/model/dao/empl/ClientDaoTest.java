package com.magdy.taxiwebappliction.model.dao.empl;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.exception.DaoException;
import org.junit.Assert;
import org.junit.Test;

public class ClientDaoTest {

    @Test
    public void save() throws DaoException {
        Client actually = new Client();
        actually.setName("magdy");
        actually.setLastName("shenoda");
        actually.setEmail("asdfdd@x");
        actually.setPassword("1234");
        actually.setPhoneNumber("12345");
        ClientDao clientDao = new ClientDao();
        clientDao.save(actually);
        Client expected = clientDao.selectById(actually.getId());
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

        ClientDao clientDao = new ClientDao();
        clientDao.save(actually);
        Client expected = clientDao.selectById(actually.getId());
        Assert.assertEquals(expected, actually);
        clientDao.deleteById(actually.getId());

    }


    @Test
    public void update() throws DaoException {
        Client actually = new Client();
        actually.setName("magdy");
        actually.setLastName("shenoda");
        actually.setEmail("asdfsssdd@x");
        actually.setPassword("1234");
        actually.setPhoneNumber("12345");
        ClientDao clientDao = new ClientDao();

        clientDao.save(actually);

        Client client = clientDao.selectById(actually.getId());

        client.setName("magdy111");
        client.setLastName("shsjienoda");
        client.setEmail("asdfsssdd@x1111");
        client.setPassword("1234111");
        client.setPhoneNumber("1234511");

        clientDao.update(client);


        Client expected = clientDao.selectById(actually.getId());
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

        ClientDao clientDao = new ClientDao();
        clientDao.save(actually);

        Client expectedClient = clientDao.selectById(actually.getId());

        Assert.assertEquals(expectedClient, actually);

        clientDao.deleteById(actually.getId());

        Client expected = clientDao.selectById(actually.getId());

        Assert.assertNull(expected);


    }
}