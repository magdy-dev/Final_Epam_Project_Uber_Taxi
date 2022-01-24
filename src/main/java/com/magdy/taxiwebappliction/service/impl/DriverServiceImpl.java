package com.magdy.taxiwebappliction.service.impl;

import com.magdy.taxiwebappliction.dao.impl.OrderDaoImpl;
import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;
import com.magdy.taxiwebappliction.service.BaseService;
import com.magdy.taxiwebappliction.service.DriverService;
import com.magdy.taxiwebappliction.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class DriverServiceImpl extends BaseService implements DriverService {
    private static final Logger log= (Logger) LogManager.getLogger();
    private final DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
    private final OrderDaoImpl orderDao = new OrderDaoImpl();
    private final Driver driver = new Driver();


    @Override
    public Driver save(Driver driver) throws ServiceException {
        log.info("SAVE_DRIVER");
        try {
            return driverDaoImpl.save(driver);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Driver> saveAll(List<Driver> list) throws ServiceException {
        log.info("SAVE_ALL_DRIVER");
        try {
            return driverDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public Driver selectById(long id) throws ServiceException {
        log.info("GET_ALL__DRIVER_BY_ID");
        try {
            return driverDaoImpl.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public List<Driver> selectAll() throws ServiceException {
        log.info("GET_ALL_DRIVER");
        try {
            return driverDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Driver update(Driver driver) throws ServiceException {
        log.info("UPDATE_DRIVER");
        try {
            return driverDaoImpl.update(driver);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        log.info("DELETE_DRIVER");
        try {
            return driverDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Driver login(String username, String password) throws ServiceException {
        log.info("LOGIN PASS");
        try {
            return driverDaoImpl.login(username, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void accept(Driver driver, Long orderId) throws ServiceException {
        try {
            orderDao.accept(driver.getId(),orderId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
