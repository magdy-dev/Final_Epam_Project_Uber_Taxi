package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.ClientDao;
import com.magdy.taxiwebappliction.model.dao.empl.DriverDao;
import com.magdy.taxiwebappliction.model.dao.empl.OrderDao;


import java.util.List;

public class OrderService implements ServiceInterface<Order> {

    private OrderDao orderDao = new OrderDao();
    private DriverDao driverDao = new DriverDao();
    private ClientDao clientDao = new ClientDao();
    private Driver driver = new Driver();

    @Override
    public Order save(Order order) throws ServiceException {
        try {
            return orderDao.save(order);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Order> saveAll(List<Order> list) throws DaoException, ServiceException {
        return orderDao.saveAll(list);
    }

    @Override
    public Order selectById(long id) throws ServiceException {
        try {
            Order order = orderDao.selectById(id);
            if (order == null) {
                return null;
            }
            long driverId = order.getDriver().getId();
            long clientId = order.getClient().getId();
            Driver driver = driverDao.selectById(driverId);
            Client client = clientDao.selectById(clientId);
            order.setDriver(driver);
            order.setClient(client);
            return order;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Order> selectAll() throws ServiceException {
        try {
            return orderDao.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Order update(Order order) throws ServiceException {
        try {
            return orderDao.update(order);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        try {
            return orderDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
