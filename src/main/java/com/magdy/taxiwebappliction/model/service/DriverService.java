package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.Driver;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.DriverDao;

import java.util.List;
import java.util.logging.Logger;

public class DriverService implements ServiceInterface<Driver> {
    private static final Logger logger = Logger.getLogger(DriverService.class.getName());
    private DriverDao driverDao = new DriverDao();
    private Driver driver = new Driver();


    @Override
    public Driver save(Driver driver) throws ServiceException {
        logger.info("SAVE_DRIVER");
        try {
            return driverDao.save(driver);
        } catch (DaoException e) {
            logger.info("can't save  Service driver");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<Driver> saveAll(List<Driver> list) throws ServiceException {
        logger.info("SAVE_ALL_DRIVER");
        try {
            return driverDao.saveAll(list);
        } catch (DaoException e) {
            logger.info("can't save all Service driver");
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public Driver selectById(long id) throws ServiceException {
        logger.info("GET_ALL__DRIVER_BY_ID");
        try {
            return driverDao.selectById(id);
        } catch (DaoException e) {
            logger.info("can't get  Service driver by id");
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public List<Driver> selectAll() throws ServiceException {
        logger.info("GET_ALL_DRIVER");
        try {
            return driverDao.selectAll();
        } catch (DaoException e) {
            logger.info("can't get all Service driver");
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Driver update(Driver driver) throws ServiceException {
        logger.info("UPDATE_DRIVER");
        try {
            return driverDao.update(driver);
        } catch (DaoException e) {
            logger.info("can't update  Service driver");
            throw new ServiceException(e.getMessage());

        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("DELETE_DRIVER");
        try {
            return driverDao.deleteById(id);
        } catch (DaoException e) {
            logger.info("can't delete  Service driver");
            throw new ServiceException(e.getMessage());
        }
    }
}
