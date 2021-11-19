package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.DriverDaoImpl;

import java.util.List;
import java.util.logging.Logger;

public class DriverServiceImpl extends BaseService implements DriverService {
    private static final Logger logger = Logger.getLogger(DriverServiceImpl.class.getName());
    private DriverDaoImpl driverDaoImpl = new DriverDaoImpl();
    private Driver driver = new Driver();


    @Override
    public Driver save(Driver driver) throws ServiceException {
        logger.info("SAVE_DRIVER");
        try {
            return driverDaoImpl.save(driver);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Driver> saveAll(List<Driver> list) throws ServiceException {
        logger.info("SAVE_ALL_DRIVER");
        try {
            return driverDaoImpl.saveAll(list);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public Driver selectById(long id) throws ServiceException {
        logger.info("GET_ALL__DRIVER_BY_ID");
        try {
            return driverDaoImpl.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public List<Driver> selectAll() throws ServiceException {
        logger.info("GET_ALL_DRIVER");
        try {
            return driverDaoImpl.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Driver update(Driver driver) throws ServiceException {
        logger.info("UPDATE_DRIVER");
        try {
            return driverDaoImpl.update(driver);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("DELETE_DRIVER");
        try {
            return driverDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Driver login(String username, String password) throws ServiceException {
        logger.info("LOGIN PASS");
        try {
            return driverDaoImpl.login(username, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
