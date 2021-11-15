package com.magdy.taxiwebappliction.service;

import com.magdy.taxiwebappliction.dao.AddressDao;
import com.magdy.taxiwebappliction.entity.Address;
import com.magdy.taxiwebappliction.dao.DaoException;
import com.magdy.taxiwebappliction.dao.impl.AddressDaoImpl;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.logging.Logger;

public class AddressServiceImpl extends BaseService implements AddressService {

    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressServiceImpl.class);

    private AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
    private Address address = new Address();

    @Override
    public Address save(Address address) throws ServiceException {
        logger.info("address saved");
        try {
            addressDaoImpl.save(address);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return address;
    }

    @Override
    public List<Address> saveAll(List<Address> list) throws ServiceException {
        logger.info("SAVE_ALL_ADDRESS");
        try {
            return addressDaoImpl.saveAll(list);

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Address selectById(long id) throws ServiceException {
        logger.info("SAVE_ALL_BY_ID");
        try {
            return addressDaoImpl.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public List<Address> selectAll() throws ServiceException {
        logger.info("GET_ALL_ADDRESS");
        try {
            return addressDaoImpl.selectAll();

        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Address update(Address address) throws ServiceException {
        logger.info("UPDATE_ADDRESS");
        try {
            return addressDaoImpl.update(address);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public boolean deleteById(long id) throws ServiceException {
        logger.info("DELETE_ADDRESS");
        try {
            return addressDaoImpl.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
