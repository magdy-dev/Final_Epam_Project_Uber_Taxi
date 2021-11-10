package com.magdy.taxiwebappliction.model.service;

import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.exception.DaoException;
import com.magdy.taxiwebappliction.exception.ServiceException;
import com.magdy.taxiwebappliction.model.dao.empl.AddressDao;

import java.util.List;
import java.util.logging.Logger;

public class AddressService implements ServiceInterface<Address> {
    private static final Logger logger = Logger.getLogger(Address.class.getName());

    private AddressDao addressDao = new AddressDao();
    private Address address = new Address();

    @Override
    public Address save(Address address) throws ServiceException {
        logger.info("SAVE_ADDRESS");

        try {
            addressDao.save(address);

        } catch (DaoException e) {
            logger.info("can't save Service address");
            throw new ServiceException(e.getMessage());
        }
        return address;
    }

    @Override
    public List<Address> saveAll(List<Address> list) throws ServiceException {
        logger.info("SAVE_ALL_ADDRESS");
        try {
            return addressDao.saveAll(list);

        } catch (DaoException e) {
            logger.info("can't save all Service address");
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Address selectById(long id) throws ServiceException {
        logger.info("SAVE_ALL_BY_ID");
        try {
            return addressDao.selectById(id);
        } catch (DaoException e) {
            logger.info("can't get by id  Service address");
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public List<Address> selectAll() throws ServiceException {
        logger.info("GET_ALL_ADDRESS");
        try {
            return addressDao.selectAll();

        } catch (DaoException e) {
            logger.info("can't get all Service address");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Address update(Address address) throws ServiceException {
        logger.info("UPDATE_ADDRESS");
        try {
            return addressDao.update(address);
        } catch (DaoException e) {
            logger.info("can't update Service address");
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("DELETE_ADDRESS");
        try {
            return addressDao.deleteById(id);
        } catch (DaoException e) {
            logger.info("can't delete Service address");
            throw new ServiceException(e.getMessage());
        }

    }
}
