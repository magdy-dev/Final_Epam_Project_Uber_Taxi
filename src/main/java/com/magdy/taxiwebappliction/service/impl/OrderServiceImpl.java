package com.magdy.taxiwebappliction.service.impl;

import com.magdy.taxiwebappliction.dao.impl.AddressDaoImpl;
import com.magdy.taxiwebappliction.entity.Client;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.entity.Order;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.ClientDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import com.magdy.taxiwebappliction.dao.impl.OrderDaoImpl;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.Service;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;


import java.util.List;

public class OrderServiceImpl extends BaseService implements Service<Order> {


    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(OrderDaoImpl.class);
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
    private ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private Driver driver = new Driver();

    @Override
    public Order save(Order order) throws ServiceException {
        logger.info("order saved");
        try {
            return orderDaoImpl.save(order);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Order> saveAll(List<Order> list) throws DaoException, ServiceException {
        return orderDaoImpl.saveAll(list);
    }

    @Override
    public Order selectById(long id) throws ServiceException {
        logger.info("order selectById");
        try {
            Order order = orderDaoImpl.selectById(id);
            if (order == null) {
                return null;
            }
            long driverId = order.getDriver().getId();
            long clientId = order.getClient().getId();
            Driver driver = driverDaoImpl.selectById(driverId);
            Client client = clientDaoImpl.selectById(clientId);
            order.setDriver(driver);
            order.setClient(client);
            return order;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Order> selectAll() throws ServiceException {
        logger.info("order selectAll");
        try {
            return orderDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Order update(Order order) throws ServiceException {
        logger.info("order update");
        try {
            return orderDaoImpl.update(order);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("order deleteById");
        try {
            return orderDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
